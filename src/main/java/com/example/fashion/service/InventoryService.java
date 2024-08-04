package com.example.fashion.service;

import com.example.fashion.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventoryService {
    private final List<InventoryItem> inventory;

    public InventoryService() {
        this.inventory = new ArrayList<>();
        // Sample inventory items
        inventory.add(new InventoryItem("1", "Jacket", "Casual", 120.0));
        inventory.add(new InventoryItem("2", "Shirt", "Formal", 80.0));
        inventory.add(new InventoryItem("3", "Trousers", "Casual", 100.0));
        inventory.add(new InventoryItem("4", "Boots", "Winter", 150.0));
        inventory.add(new InventoryItem("5", "Sweatshirt", "Casual", 250.0));
        inventory.add(new InventoryItem("6", "Knit Sweater", "Winter", 100.0));
        inventory.add(new InventoryItem("7", "A-Line", "Formal", 160.0));
        inventory.add(new InventoryItem("8", "Cargo Pants", "Casual", 100.0));
        inventory.add(new InventoryItem("9", "Puffer Vest", "Winter", 50.0));
        inventory.add(new InventoryItem("10", "Linen Blend Pant", "Formal", 350.0));
    }

    public List<InventoryItem> getAvailableInventory() {
        return inventory;
    }
}
