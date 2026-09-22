package com.devspace.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devspace.api.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}