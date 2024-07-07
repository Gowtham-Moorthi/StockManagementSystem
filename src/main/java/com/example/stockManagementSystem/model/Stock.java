package com.example.stockManagementSystem.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "stocks")
public class Stock {
    @Id
    private String id;
    private String symbol;
    private String name;
    private List<PriceEntry> prices;

    // Constructors, getters, and setters

    public Stock() {}

    public Stock(String symbol, String name, List<PriceEntry> prices) {
        this.symbol = symbol;
        this.name = name;
        this.prices = prices;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PriceEntry> getPrices() {
        return prices;
    }

    public void setPrices(List<PriceEntry> prices) {
        this.prices = prices;
    }

    public void adjustPrice(boolean isBuy, int quantity) {
        if (prices == null || prices.isEmpty()) {
            return;
        }

        PriceEntry latestEntry = prices.get(prices.size() - 1);
        double newPrice;

        if (isBuy) {
            newPrice = latestEntry.getPrice() * (1 + 0.01 * quantity / 100);
        } else {
            newPrice = latestEntry.getPrice() * (1 - 0.01 * quantity / 100);
        }

        prices.add(new PriceEntry(latestEntry.getDate(), newPrice, latestEntry.getVolume()));
    }

    public static class PriceEntry {
        private String date;
        private double price;
        private long volume;

        // Constructors, getters, and setters
        public PriceEntry() {}

        public PriceEntry(String date, double price, long volume) {
            this.date = date;
            this.price = price;
            this.volume = volume;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public long getVolume() {
            return volume;
        }

        public void setVolume(long volume) {
            this.volume = volume;
        }
    }
}
