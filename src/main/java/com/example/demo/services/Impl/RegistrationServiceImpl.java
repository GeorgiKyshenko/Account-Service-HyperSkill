package com.example.demo.services.Impl;

import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.models.DTOs.SignUpResponse;
import com.example.demo.models.User;
import com.example.demo.repositories.RegistrationRepository;
import com.example.demo.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResponse register(User sigUp) throws UserAlreadyExistsException {
        boolean userExists = userEmailExists(sigUp.getEmail());
        if (userExists) {
            throw new UserAlreadyExistsException();
        } else {
            sigUp.setPassword(passwordEncoder.encode(sigUp.getPassword()));
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
