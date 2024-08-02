package com.example.fashion;

import com.example.fashion.model.UserPreferences;
import com.example.fashion.service.RecommendationService;
import com.example.fashion.service.InventoryService;
import com.example.fashion.service.PurchaseHistoryService;
import com.example.fashion.service.DemographicService;
import com.example.fashion.controller.RecommendationController;
import com.example.fashion.model.Outfit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class RecommendationControllerTest {

    private RecommendationService recommendationService;
    private RecommendationController recommendationController;

    @BeforeEach
    public void setUp() {
        // Initialize services and controller
        InventoryService inventoryService = new InventoryService();
        PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService();
        DemographicService demographicService = new DemographicService();

        recommendationService = new RecommendationService(inventoryService, purchaseHistoryService, demographicService);
        recommendationController = new RecommendationController(recommendationService);
    }

    @Test
    public void testGetRecommendations() {
        String userId = "user1";
        UserPreferences preferences = new UserPreferences("Christmas", "Casual", 300.0);

        ResponseEntity<List<Outfit>> response = recommendationController.getRecommendations(userId, preferences);

        // Assertions
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertFalse(response.getBody().isEmpty());
    }
}
