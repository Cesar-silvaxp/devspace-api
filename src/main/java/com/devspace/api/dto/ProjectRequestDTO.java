package com.devspace.api.dto;

import java.util.Set;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProjectRequestDTO {

    @NotBlank(message = "O título do projeto é obrigatório.")
    @Size(max = 150, message = "O título deve ter no máximo 150 caracteres.")
    private String title;

    @Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres.")
    private String description;

    @NotBlank(message = "A URL do projeto é obrigatória.")
    @URL(message = "A URL do projeto deve ser válida.")
    private String projectUrl;

    @NotNull(message = "O perfil é obrigatório.")
    private Long profileId;

    private Set<Long> technologyIds;

    public ProjectRequestDTO() {
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
}