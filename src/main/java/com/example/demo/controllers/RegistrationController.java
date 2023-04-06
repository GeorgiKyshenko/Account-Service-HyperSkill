package com.example.demo.controllers;

import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.models.DTOs.SignUpResponse;
import com.example.demo.models.SignUpForm;
import com.example.demo.services.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> registration(@RequestBody @Valid SignUpForm sigUp) throws UserAlreadyExistsException {
        SignUpResponse register = registrationService.register(sigUp);
        return ResponseEntity.ok().body(register);
    }
}
