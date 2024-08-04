package com.example.fashion.service;

import com.example.fashion.model.Feedback;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackService {
    private final List<Feedback> feedbackList = new ArrayList<>();

    public void submitFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return new ArrayList<>(feedbackList);
    }
}
