package com.devspace.api.dto;

public class ProfileResponseDTO {

    private Long id;
    private String name;
    private String bio;
    private String githubUrl;

    public ProfileResponseDTO() {
    }

    public ProfileResponseDTO(Long id, String name, String bio, String githubUrl) {
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.githubUrl = githubUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getGithubUrl() {
        return githubUrl;
    }

    public void setGithubUrl(String githubUrl) {
        this.githubUrl = githubUrl;
    }
}