package com.example.stockManagementSystem.repository;

import com.example.stockManagementSystem.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    // Define custom query methods if needed
}
