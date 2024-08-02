// src/main/java/com/example/fashion/service/RecommendationService.java

package com.example.fashion.service;

import com.example.fashion.model.InventoryItem;
import com.example.fashion.model.Outfit;
import com.example.fashion.model.UserPreferences;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {
    private final InventoryService inventoryService;
    private final PurchaseHistoryService purchaseHistoryService;
    private final DemographicService demographicService;

    public RecommendationService(InventoryService inventoryService, PurchaseHistoryService purchaseHistoryService, DemographicService demographicService) {
        this.inventoryService = inventoryService;
        this.purchaseHistoryService = purchaseHistoryService;
        this.demographicService = demographicService;
    }

    public List<Outfit> recommendOutfits(UserPreferences preferences, String userId) {
        List<InventoryItem> inventory = inventoryService.getAvailableInventory();

        // Fetch purchase history
        List<String> previousPurchases = purchaseHistoryService.getPurchasedItemsForUser(userId);

        // Fetch demographic group
        String demographicGroup = demographicService.getDemographicGroupForUser(userId);

        // Fetch popular items for the demographic
        List<String> popularItems = demographicService.getPopularItemsForDemographic(demographicGroup);

        return inventory.stream()
                .filter(item -> !previousPurchases.contains(item.getId())) // Avoid previously purchased items
                .filter(item -> popularItems.contains(item.getId()) || item.getStyle().equalsIgnoreCase(preferences.getStyle())) // Prefer popular items or user-preferred style
                .filter(item -> item.getPrice() <= preferences.getBudget())
                .map(item -> new Outfit(item.getId(), item.getType(), item.getPrice()))
                .collect(Collectors.toList());
    }
}
