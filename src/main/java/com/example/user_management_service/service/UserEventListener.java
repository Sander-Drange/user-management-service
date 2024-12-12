package com.example.user_management_service.service;

import com.example.user_management_service.dto.UserProfileRequest;
import com.example.user_management_service.dto.events.UserRegisteredEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventListener {

    private final UserService userService;

    @RabbitListener(queues = "user.queue")
    public void handleUserRegistration(UserRegisteredEvent event) {
        log.info("Received user registration event for user: {}", event.getEmail());
        UserProfileRequest profileRequest = new UserProfileRequest();
        profileRequest.setFirstName(event.getFirstname());
        profileRequest.setLastName(event.getLastname());
        profileRequest.setEmail(event.getEmail());

        userService.createUserProfile(event.getUserId(), profileRequest);
        log.info("Successfully processed user registration event");
    }
}
