package com.example.fashion.controller;

import com.example.fashion.model.Outfit;
import com.example.fashion.model.UserPreferences;
import com.example.fashion.service.RecommendationService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;
    private static final Logger logger = LoggerFactory.getLogger(RecommendationController.class);

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<List<Outfit>> getRecommendations(@PathVariable String userId, @RequestBody UserPreferences preferences) {
        logger.info("Fetching recommendations for user: {}", userId);
        List<Outfit> recommendations = recommendationService.recommendOutfits(preferences);
        if (recommendations.isEmpty()) {
            logger.info("No recommendations found for user: {}", userId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(recommendations);
    }
}
