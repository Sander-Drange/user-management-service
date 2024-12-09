package com.example.user_management_service.dto;

import lombok.Data;
import java.util.Date;

@Data
public class UserProfileResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String bio;
    private String phoneNumber;
    private Date createdAt;
    private Date updatedAt;
}