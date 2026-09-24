package com.devspace.api.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devspace.api.dto.FeedbackRequestDTO;
import com.devspace.api.dto.FeedbackResponseDTO;
import com.devspace.api.entity.Feedback;
import com.devspace.api.entity.Project;
import com.devspace.api.repository.FeedbackRepository;
import com.devspace.api.repository.ProjectRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final ProjectRepository projectRepository;

    public FeedbackService(
            FeedbackRepository feedbackRepository,
            ProjectRepository projectRepository) {

        this.feedbackRepository = feedbackRepository;
        this.projectRepository = projectRepository;
    }

    @Transactional
    public FeedbackResponseDTO create(Long projectId, FeedbackRequestDTO request) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Projeto não encontrado com o ID: " + projectId));

        Feedback feedback = new Feedback();
        feedback.setRating(request.getRating());
        feedback.setComment(request.getComment());
        feedback.setProject(project);

        Feedback savedFeedback = feedbackRepository.saveAndFlush(feedback);

        Double averageRating =
                feedbackRepository.findAverageRatingByProjectId(projectId);

        project.setAverageRating(
                averageRating != null ? averageRating : 0.0
        );

        projectRepository.save(project);

        return new FeedbackResponseDTO(
                savedFeedback.getId(),
                savedFeedback.getRating(),
                savedFeedback.getComment(),
                project.getId()
        );
    }
}