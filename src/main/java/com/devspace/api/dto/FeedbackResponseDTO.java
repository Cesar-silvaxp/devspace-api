package com.devspace.api.dto;

public class FeedbackResponseDTO {

    private Long id;
    private Integer rating;
    private String comment;
    private Long projectId;

    public FeedbackResponseDTO() {
    }

    public FeedbackResponseDTO(
            Long id,
            Integer rating,
            String comment,
            Long projectId) {

        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.projectId = projectId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}