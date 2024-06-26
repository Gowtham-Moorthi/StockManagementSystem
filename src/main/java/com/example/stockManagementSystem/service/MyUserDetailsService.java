package com.example.stockManagementSystem.service;

import com.example.stockManagementSystem.model.User;
import com.example.stockManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService {

    @Autowired
    private UserRepository repository;
    public List<User> findAllUsers(){
        return repository.findAll();
    }
}
