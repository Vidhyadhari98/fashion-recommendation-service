// src/test/java/com/example/fashion/RecommendationServiceTest.java

package com.example.fashion;

import com.example.fashion.model.UserPreferences;
import com.example.fashion.service.RecommendationService;
import com.example.fashion.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RecommendationServiceTest {
    private final InventoryService inventoryService = new InventoryService();
    private final RecommendationService recommendationService = new RecommendationService(inventoryService);

    @Test
    public void testRecommendOutfits() {
        UserPreferences preferences = new UserPreferences("Wedding", "Formal", 200.0);
        assertFalse(recommendationService.recommendOutfits(preferences).isEmpty());
    }
}
