package com.example.stockManagementSystem.model;

import org.bson.types.ObjectId;

public class Transaction {
    private ObjectId id;
    private ObjectId userId;
    private String symbol;
    private int quantity;
    private double price;
    private String date;
    private String type;
    private String status;
    private ObjectId matchedTransactionId;

    // Constructor
    public Transaction(ObjectId id, ObjectId userId, String symbol, int quantity, double price, String date, String type, String status, ObjectId matchedTransactionId) {
        this.id = id;
        this.userId = userId;
        this.symbol = symbol;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
        this.type = type;
        this.status = status;
        this.matchedTransactionId = matchedTransactionId;
    }

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ObjectId getMatchedTransactionId() {
        return matchedTransactionId;
    }

    public void setMatchedTransactionId(ObjectId matchedTransactionId) {
        this.matchedTransactionId = matchedTransactionId;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", userId=" + userId +
                ", symbol='" + symbol + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", matchedTransactionId=" + matchedTransactionId +
                '}';
    }
}
