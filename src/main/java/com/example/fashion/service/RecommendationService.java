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

    public RecommendationService(InventoryService inventoryService,
                                 PurchaseHistoryService purchaseHistoryService,
                                 DemographicService demographicService) {
        this.inventoryService = inventoryService;
        this.purchaseHistoryService = purchaseHistoryService;
        this.demographicService = demographicService;
    }

    public List<Outfit> recommendOutfits(UserPreferences preferences) {
        List<InventoryItem> inventory = inventoryService.getAvailableInventory();

        return inventory.stream()
                .filter(item -> item.getStyle().equalsIgnoreCase(preferences.getStyle())
                        && item.getPrice() <= preferences.getBudget())
                .map(item -> new Outfit(item.getId(), item.getType(), item.getPrice()))
                .collect(Collectors.toList());
    }
}
