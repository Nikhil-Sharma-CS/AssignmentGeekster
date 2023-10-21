package org.example.AssignmentGeekster.Controller;

import org.example.AssignmentGeekster.Model.User;
import org.example.AssignmentGeekster.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("public/users/test")
    public String getData()
    {
        return "Hello from secured.";
    }

    @GetMapping("public/getUsers")
    public List<User> getUsers()
    {
        return userService.getUsers();
    }

    @PostMapping("admin/createUser")
    public String createUser(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @PostMapping("public/createAdmin")
    public String createAdmin(@RequestBody User user)
    {
        return userService.createUser(user);
    }

    @DeleteMapping("/admin/deleteUserById/{ID}")
    public String deleteUserById(@PathVariable Integer ID)
    {
        return userService.deleteUserById(ID);
    }
}
