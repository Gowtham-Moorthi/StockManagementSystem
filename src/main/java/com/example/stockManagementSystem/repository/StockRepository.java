package com.example.stockManagementSystem.repository;

import com.example.stockManagementSystem.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
    Stock findBySymbol(String symbol);
}
