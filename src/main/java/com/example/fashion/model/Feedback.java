// src/main/java/com/example/fashion/model/Feedback.java

package com.example.fashion.model;

public class Feedback {
    private String userId;
    private String recommendationId;
    private String comments;
    private int rating; // e.g., rating out of 5

    public Feedback(String userId, String recommendationId, String comments, int rating) {
        this.userId = userId;
        this.recommendationId = recommendationId;
        this.comments = comments;
        this.rating = rating;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRecommendationId() {
        return recommendationId;
    }

    public void setRecommendationId(String recommendationId) {
        this.recommendationId = recommendationId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
