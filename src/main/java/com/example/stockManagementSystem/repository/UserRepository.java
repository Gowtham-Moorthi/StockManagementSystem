package com.example.stockManagementSystem.repository;

import com.example.stockManagementSystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
