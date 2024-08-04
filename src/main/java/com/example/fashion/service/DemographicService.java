package com.example.fashion.service;

import com.example.fashion.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemographicService {
    private final Map<String, User> userDatabase = new HashMap<>();

    public DemographicService() {
        // Sample data
        userDatabase.put("user1", new User("user1", "young_adults"));
    }

    public String getDemographicGroupForUser(String userId) {
        User user = userDatabase.get(userId);
        return user != null ? user.getDemographicGroup() : null;
    }

    public List<String> getPopularItemsForDemographic(String demographicGroup) {
        // For simplicity, let's assume these are hardcoded recommendations per group
        switch (demographicGroup) {
            case "young_adults":
                return List.of("1", "3"); // IDs of popular items for this demographic
            // Add more cases for other demographic groups
            default:
                return List.of();
        }
    }
}
