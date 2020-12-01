package com.endava.trainingapi.repository;

import com.endava.trainingapi.model.Community;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunityRepository extends JpaRepository<Community, UUID> {
}
