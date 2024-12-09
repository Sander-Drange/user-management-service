package com.example.user_management_service.repository;

import com.example.user_management_service.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
    Optional findByEmail(String email);
}