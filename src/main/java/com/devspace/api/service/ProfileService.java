package com.devspace.api.service;

import org.springframework.stereotype.Service;

import com.devspace.api.dto.ProfileRequestDTO;
import com.devspace.api.dto.ProfileResponseDTO;
import com.devspace.api.entity.Profile;
import com.devspace.api.repository.ProfileRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public ProfileResponseDTO create(ProfileRequestDTO request) {
        Profile profile = new Profile();

        profile.setName(request.getName());
        profile.setBio(request.getBio());
        profile.setGithubUrl(request.getGithubUrl());

        Profile savedProfile = profileRepository.save(profile);

        return toResponseDTO(savedProfile);
    }

    public ProfileResponseDTO findById(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        "Perfil não encontrado com o ID: " + id));

        return toResponseDTO(profile);
    }

    private ProfileResponseDTO toResponseDTO(Profile profile) {
        return new ProfileResponseDTO(
                profile.getId(),
                profile.getName(),
                profile.getBio(),
                profile.getGithubUrl()
        );
    }
}