package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userserv;

    @GetMapping
    public List<User> getAllUsers() {
        return userserv.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userserv.save(user);
    }
}