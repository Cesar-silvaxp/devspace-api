package com.devspace.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devspace.api.dto.TechnologyRequestDTO;
import com.devspace.api.dto.TechnologyResponseDTO;
import com.devspace.api.entity.Technology;
import com.devspace.api.repository.TechnologyRepository;

@Service
public class TechnologyService {

    private final TechnologyRepository technologyRepository;

    public TechnologyService(TechnologyRepository technologyRepository) {
        this.technologyRepository = technologyRepository;
    }

    public TechnologyResponseDTO create(TechnologyRequestDTO request) {
        Technology technology = new Technology();

        technology.setName(request.getName());

        Technology savedTechnology = technologyRepository.save(technology);

        return toResponseDTO(savedTechnology);
    }

    public List<TechnologyResponseDTO> findAll() {
        return technologyRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .toList();
    }

    private TechnologyResponseDTO toResponseDTO(Technology technology) {
        return new TechnologyResponseDTO(
                technology.getId(),
                technology.getName()
        );
    }
}