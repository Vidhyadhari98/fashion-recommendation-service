package com.example.fashion;

import com.example.fashion.model.UserPreferences;
import com.example.fashion.model.Outfit;
import com.example.fashion.service.RecommendationService;
import com.example.fashion.service.InventoryService;
import com.example.fashion.service.PurchaseHistoryService;
import com.example.fashion.service.DemographicService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class RecommendationServiceTest {

    private InventoryService inventoryService;
    private PurchaseHistoryService purchaseHistoryService;
    private DemographicService demographicService;
    private RecommendationService recommendationService;

    @BeforeEach
    public void setUp() {
        // Use real or mocked services depending on test requirements
        inventoryService = new InventoryService();

        // Mocking these services since they may not be implemented yet
        purchaseHistoryService = mock(PurchaseHistoryService.class);
        demographicService = mock(DemographicService.class);

        recommendationService = new RecommendationService(inventoryService, purchaseHistoryService, demographicService);
    }

    @Test
    public void testRecommendOutfits() {
        UserPreferences preferences = new UserPreferences("Wedding", "Formal", 200.0);
        List<Outfit> recommendations = recommendationService.recommendOutfits(preferences);

        assertFalse(recommendations.isEmpty());
    }
}
