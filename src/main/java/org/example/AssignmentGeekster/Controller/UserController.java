package org.example.AssignmentGeekster.Controller;

import org.example.AssignmentGeekster.Model.User;
import org.example.AssignmentGeekster.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
