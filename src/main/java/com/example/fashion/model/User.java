// src/main/java/com/example/fashion/model/User.java

package com.example.fashion.model;

public class User {
    private String userId;
    private String demographicGroup;

    public User(String userId, String demographicGroup) {
        this.userId = userId;
        this.demographicGroup = demographicGroup;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDemographicGroup() {
        return demographicGroup;
    }

    public void setDemographicGroup(String demographicGroup) {
        this.demographicGroup = demographicGroup;
    }
}
