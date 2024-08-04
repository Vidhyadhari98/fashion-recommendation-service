package com.example.fashion.service;

import com.example.fashion.model.PurchaseHistory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PurchaseHistoryService {
    private final Map<String, PurchaseHistory> historyDatabase = new HashMap<>();

    public PurchaseHistoryService() {
        // Sample data
        historyDatabase.put("user1", new PurchaseHistory("user1", List.of("1", "2")));
    }

    public List<String> getPurchasedItemsForUser(String userId) {
        PurchaseHistory history = historyDatabase.get(userId);
        return history != null ? history.getPurchasedItemIds() : new ArrayList<>();
    }
}
