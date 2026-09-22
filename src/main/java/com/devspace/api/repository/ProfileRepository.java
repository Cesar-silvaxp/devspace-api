package com.devspace.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devspace.api.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}