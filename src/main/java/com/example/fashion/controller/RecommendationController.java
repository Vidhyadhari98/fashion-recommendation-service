package com.example.fashion.controller;

import com.example.fashion.model.Outfit;
import com.example.fashion.model.UserPreferences;
import com.example.fashion.service.RecommendationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {
    private final RecommendationService recommendationService;

    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<List<Outfit>> getRecommendations(@PathVariable String userId, @RequestBody UserPreferences preferences) {
        List<Outfit> recommendations = recommendationService.recommendOutfits(preferences, userId);
        return ResponseEntity.ok(recommendations);
    }
}
