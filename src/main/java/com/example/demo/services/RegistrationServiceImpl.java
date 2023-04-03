package com.example.demo.services;

import com.example.demo.models.DTOs.SignUpResponse;
import com.example.demo.models.SignUpForm;
import com.example.demo.repositories.RegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Override
    public SignUpResponse register(SignUpForm sigUp) {
        registrationRepository.save(sigUp);
        return SignUpResponse.builder()
                .name(sigUp.getName())
                .lastName(sigUp.getLastName())
                .email(sigUp.getEmail()).build();
    }
}
