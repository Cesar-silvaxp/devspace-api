package com.devspace.api.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devspace.api.dto.ProjectRequestDTO;
import com.devspace.api.dto.ProjectResponseDTO;
import com.devspace.api.entity.Profile;
import com.devspace.api.entity.Project;
import com.devspace.api.entity.Technology;
import com.devspace.api.repository.ProfileRepository;
import com.devspace.api.repository.ProjectRepository;
import com.devspace.api.repository.TechnologyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional(readOnly = true)
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProfileRepository profileRepository;
    private final TechnologyRepository technologyRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            ProfileRepository profileRepository,
            TechnologyRepository technologyRepository) {

        this.projectRepository = projectRepository;
        this.profileRepository = profileRepository;
        this.technologyRepository = technologyRepository;
    }

    @Transactional
    public ProjectResponseDTO create(ProjectRequestDTO request) {

        Profile profile = profileRepository.findById(request.getProfileId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Perfil não encontrado com o ID: " + request.getProfileId()));

        Set<Technology> technologies = new HashSet<>();

        if (request.getTechnologyIds() != null && !request.getTechnologyIds().isEmpty()) {
            technologies = new HashSet<>(
                    technologyRepository.findAllById(request.getTechnologyIds())
            );
        }

        Project project = new Project();
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setProjectUrl(request.getProjectUrl());
        project.setProfile(profile);
        project.setTechnologies(technologies);

        Project savedProject = projectRepository.save(project);

        return toResponseDTO(savedProject);
    }

    public List<ProjectResponseDTO> findAll() {

        return projectRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private ProjectResponseDTO toResponseDTO(Project project) {

        Set<Long> technologyIds = project.getTechnologies()
                .stream()
                .map(Technology::getId)
                .collect(java.util.stream.Collectors.toSet());

        return new ProjectResponseDTO(
                project.getId(),
                project.getTitle(),
                project.getDescription(),
                project.getProjectUrl(),
                project.getProfile().getId(),
                technologyIds
        );
    }
}