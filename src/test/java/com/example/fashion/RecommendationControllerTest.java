package com.example.fashion;

import com.example.fashion.controller.RecommendationController;
import com.example.fashion.model.Outfit;
import com.example.fashion.model.UserPreferences;
import com.example.fashion.service.RecommendationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecommendationControllerTest {

    @Mock
    private RecommendationService recommendationService;

    @InjectMocks
    private RecommendationController recommendationController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetRecommendations() {
        String userId = "user1";
        UserPreferences preferences = new UserPreferences("Christmas", "Casual", 300.0);
        List<Outfit> expectedOutfits = Arrays.asList(
                new Outfit("1", "Jacket", 150.0),
                new Outfit("2", "Boots", 100.0)
        );

        // Mock the recommendationService to return expectedOutfits
        when(recommendationService.recommendOutfits(preferences)).thenReturn(expectedOutfits);

        ResponseEntity<List<Outfit>> response = recommendationController.getRecommendations(userId, preferences);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(expectedOutfits, response.getBody());
    }
}
