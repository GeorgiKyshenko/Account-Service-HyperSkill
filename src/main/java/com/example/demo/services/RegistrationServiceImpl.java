package com.example.demo.services;

import com.example.demo.exceptions.UserAlreadyExistsException;
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
    public SignUpResponse register(SignUpForm sigUp) throws UserAlreadyExistsException {
        boolean userExists = userEmailExists(sigUp.getEmail());
        if (userExists) {
            throw new UserAlreadyExistsException();
        } else {
            registrationRepository.save(sigUp);
            return SignUpResponse.builder()
                    .name(sigUp.getName())
                    .lastName(sigUp.getLastName())
                    .email(sigUp.getEmail()).build();
        }
    }

    @Override
    public boolean userEmailExists(String email) {
        return registrationRepository.existsByEmail(email);
    }
}
