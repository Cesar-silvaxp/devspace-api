package com.devspace.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devspace.api.dto.ProjectRequestDTO;
import com.devspace.api.dto.ProjectResponseDTO;
import com.devspace.api.service.ProjectService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponseDTO> create(
            @Valid @RequestBody ProjectRequestDTO request) {

        ProjectResponseDTO response = projectService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponseDTO>> findAll() {

        List<ProjectResponseDTO> response = projectService.findAll();

        return ResponseEntity.ok(response);
    }
}