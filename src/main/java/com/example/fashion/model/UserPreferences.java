package com.example.fashion.model;

public class UserPreferences {
    private String eventType;
    private String style;
    private double budget;

    public UserPreferences(String eventType, String style, double budget) {
        this.eventType = eventType;
        this.style = style;
        this.budget = budget;
    }

    // Getters and setters
    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
}
