package com.devspace.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devspace.api.entity.Technology;

public interface TechnologyRepository extends JpaRepository<Technology, Long> {

}