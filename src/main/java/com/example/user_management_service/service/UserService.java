package com.example.user_management_service.service;

import com.example.user_management_service.dto.UserProfileRequest;
import com.example.user_management_service.dto.UserProfileResponse;
import com.example.user_management_service.entity.UserProfile;
import com.example.user_management_service.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserProfileRepository userProfileRepository;

    public UserProfileResponse createUserProfile(String userId, UserProfileRequest request) {
        UserProfile userProfile = UserProfile.builder()
                .userId(userId)
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .bio(request.getBio())
                .phoneNumber(request.getPhoneNumber())
                .build();

        UserProfile savedProfile = userProfileRepository.save(userProfile);
        return convertToResponse(savedProfile);
    }

    private UserProfileResponse convertToResponse(UserProfile profile) {
        UserProfileResponse response = new UserProfileResponse();
        // Map properties from profile to response
        return response;
    }
}