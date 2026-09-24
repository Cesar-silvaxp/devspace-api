package com.devspace.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devspace.api.dto.FeedbackRequestDTO;
import com.devspace.api.dto.FeedbackResponseDTO;
import com.devspace.api.service.FeedbackService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping("/{id}/feedbacks")
    public ResponseEntity<FeedbackResponseDTO> createFeedback(
            @PathVariable Long id,
            @Valid @RequestBody FeedbackRequestDTO request) {

        FeedbackResponseDTO response =
                feedbackService.create(id, request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}