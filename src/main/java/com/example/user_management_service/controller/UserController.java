package com.example.user_management_service.controller;

import com.example.user_management_service.dto.UserProfileRequest;
import com.example.user_management_service.dto.UserProfileResponse;
import com.example.user_management_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity createUserProfile(
            @RequestHeader("X-User-ID") String userId,
            @RequestBody UserProfileRequest request
    ) {
        return ResponseEntity.ok(userService.createUserProfile(userId, request));
    }
}