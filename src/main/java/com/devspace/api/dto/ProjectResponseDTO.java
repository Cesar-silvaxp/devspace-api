package com.devspace.api.dto;

import java.util.Set;

public class ProjectResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String projectUrl;
    private Long profileId;
    private Set<Long> technologyIds;
    private Double averageRating;
    private Integer upvotes;

    public ProjectResponseDTO() {
    }

    public ProjectResponseDTO(
            Long id,
            String title,
            String description,
            String projectUrl,
            Long profileId,
            Set<Long> technologyIds,
            Double averageRating,
            Integer upvotes) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.projectUrl = projectUrl;
        this.profileId = profileId;
        this.technologyIds = technologyIds;
        this.averageRating = averageRating;
        this.upvotes = upvotes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProjectUrl() {
        return projectUrl;
    }

    public void setProjectUrl(String projectUrl) {
        this.projectUrl = projectUrl;
    }

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }

    public Set<Long> getTechnologyIds() {
        return technologyIds;
    }

    public void setTechnologyIds(Set<Long> technologyIds) {
        this.technologyIds = technologyIds;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }
}