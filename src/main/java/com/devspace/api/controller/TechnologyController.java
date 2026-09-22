package com.devspace.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devspace.api.dto.TechnologyRequestDTO;
import com.devspace.api.dto.TechnologyResponseDTO;
import com.devspace.api.service.TechnologyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/technologies")
public class TechnologyController {

    private final TechnologyService technologyService;

    public TechnologyController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @PostMapping
    public ResponseEntity<TechnologyResponseDTO> create(
            @Valid @RequestBody TechnologyRequestDTO request) {

        TechnologyResponseDTO response = technologyService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<TechnologyResponseDTO>> findAll() {

        List<TechnologyResponseDTO> response = technologyService.findAll();

        return ResponseEntity.ok(response);
    }
}