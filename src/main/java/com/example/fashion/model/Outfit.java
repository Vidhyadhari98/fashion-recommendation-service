package com.example.fashion.model;

public class Outfit {
    private String name;
    private String type;
    private double price;

    public Outfit(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
