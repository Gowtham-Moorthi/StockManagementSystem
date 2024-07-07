package com.example.stockManagementSystem.controller;

import com.example.stockManagementSystem.model.Stock;
import com.example.stockManagementSystem.model.Stock.PriceEntry;
import com.example.stockManagementSystem.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stocks")
public class StockController {

    @Autowired
    private StockRepository stockRepository;

    private double userBalance = 5000.0;  // Initial balance
    private Map<String, Integer> userInventory = new HashMap<>();  // User's stock inventory

    @GetMapping
    public List<String> getAllStockSymbols() {
        List<Stock> stocks = stockRepository.findAll();
        return stocks.stream()
                .map(Stock::getSymbol)
                .collect(Collectors.toList());
    }

    @GetMapping("/{symbol}")
    public Stock getStockBySymbol(@PathVariable String symbol) {
        return stockRepository.findBySymbol(symbol);
    }

    @PostMapping("/buy")
    public String buyStock(@RequestParam String symbol, @RequestParam int quantity) {
        Stock stock = stockRepository.findBySymbol(symbol);
        if (stock == null || stock.getPrices().isEmpty()) {
            return "Stock not found or no price data available";
        }

        double price = stock.getPrices().get(stock.getPrices().size() - 1).getPrice();
        double totalCost = quantity * price;
        if (userBalance < totalCost) {
            return "Insufficient balance";
        }

        userBalance -= totalCost;
        userInventory.put(symbol, userInventory.getOrDefault(symbol, 0) + quantity);

        stock.adjustPrice(true, quantity);
        stockRepository.save(stock);

        return "Bought " + quantity + " shares of " + symbol;
    }

    @PostMapping("/sell")
    public String sellStock(@RequestParam String symbol, @RequestParam int quantity) {
        Stock stock = stockRepository.findBySymbol(symbol);
        if (stock == null || stock.getPrices().isEmpty()) {
            return "Stock not found or no price data available";
        }

        int currentQuantity = userInventory.getOrDefault(symbol, 0);
        if (currentQuantity < quantity) {
            return "Insufficient shares to sell";
        }

        double price = stock.getPrices().get(stock.getPrices().size() - 1).getPrice();
        double totalProceeds = quantity * price;

        userBalance += totalProceeds;
        userInventory.put(symbol, currentQuantity - quantity);

        stock.adjustPrice(false, quantity);
        stockRepository.save(stock);

        return "Sold " + quantity + " shares of " + symbol;
    }

    @GetMapping("/user")
    public Map<String, Object> getUser() {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("balance", userBalance);
        userInfo.put("inventory", userInventory);
        return userInfo;
    }

    @GetMapping("/user/stocks")
    public Map<String, Integer> getUserStocks() {
        return userInventory;
    }
}