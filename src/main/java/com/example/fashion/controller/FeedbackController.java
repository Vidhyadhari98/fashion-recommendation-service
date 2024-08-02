// src/main/java/com/example/fashion/controller/FeedbackController.java

package com.example.fashion.controller;

import com.example.fashion.model.Feedback;
import com.example.fashion.service.FeedbackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Void> submitFeedback(@RequestBody Feedback feedback) {
        feedbackService.submitFeedback(feedback);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getFeedback() {
        return ResponseEntity.ok(feedbackService.getAllFeedback());
    }
}
