package com.example.fashion.model;

public class InventoryItem {
    private String id;
    private String type;
    private String style;
    private double price;

    public InventoryItem(String id, String type, String style, double price) {
        this.id = id;
        this.type = type;
        this.style = style;
        this.price = price;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
