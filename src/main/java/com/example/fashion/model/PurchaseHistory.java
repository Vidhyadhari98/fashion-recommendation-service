// src/main/java/com/example/fashion/model/PurchaseHistory.java

package com.example.fashion.model;

import java.util.List;

public class PurchaseHistory {
    private String userId;
    private List<String> purchasedItemIds;

    public PurchaseHistory(String userId, List<String> purchasedItemIds) {
        this.userId = userId;
        this.purchasedItemIds = purchasedItemIds;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getPurchasedItemIds() {
        return purchasedItemIds;
    }

    public void setPurchasedItemIds(List<String> purchasedItemIds) {
        this.purchasedItemIds = purchasedItemIds;
    }
}
