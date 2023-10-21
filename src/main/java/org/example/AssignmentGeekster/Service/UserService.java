package org.example.AssignmentGeekster.Service;

import org.example.AssignmentGeekster.Model.User;
import org.example.AssignmentGeekster.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public String createUser(User user) {
        userRepo.save(user);

        return "User saved";
    }

    public String deleteUserById(Integer id) {
        if(userRepo.existsById(id))
        {
            userRepo.deleteById(id);
            return "User deleted";
        }
        else
            return "User not found with id";
    }
}
