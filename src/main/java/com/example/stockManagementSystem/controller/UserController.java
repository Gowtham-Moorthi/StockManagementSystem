package com.example.stockManagementSystem.controller;

import com.example.stockManagementSystem.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.stockManagementSystem.model.User;

import java.util.List;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users= userRepository.findAll();
        return userRepository.findAll();
    }
}
