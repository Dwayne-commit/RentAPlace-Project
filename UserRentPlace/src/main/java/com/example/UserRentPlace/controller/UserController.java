package com.example.UserRentPlace.controller;

import com.example.UserRentPlace.model.User;
import com.example.UserRentPlace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PutMapping("/add")
    public User createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return user1;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/update/{id}")
    public User updateUserById(@RequestBody User user, @PathVariable("id") Long id){
        return userService.updateUser(user, id);
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }
}
