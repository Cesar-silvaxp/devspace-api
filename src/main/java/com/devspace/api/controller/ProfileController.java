package com.devspace.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devspace.api.dto.ProfileRequestDTO;
import com.devspace.api.dto.ProfileResponseDTO;
import com.devspace.api.service.ProfileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/profiles")
public class ProfileController {

    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @PostMapping
    public ResponseEntity<ProfileResponseDTO> create(
            @Valid @RequestBody ProfileRequestDTO request) {

        ProfileResponseDTO response = profileService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponseDTO> findById(
            @PathVariable Long id) {

        ProfileResponseDTO response = profileService.findById(id);

        return ResponseEntity.ok(response);
    }
}