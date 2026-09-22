package com.devspace.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devspace.api.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}