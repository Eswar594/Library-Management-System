package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userrepo;

    public List<User> findAll() {
        return userrepo.findAll();
    }

    public User save(User user) {
        return userrepo.save(user);
    }
}