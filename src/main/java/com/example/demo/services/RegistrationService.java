package com.example.demo.services;

import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.models.DTOs.SignUpResponse;
import com.example.demo.models.SignUpForm;

public interface RegistrationService {

    SignUpResponse register(SignUpForm sigUp) throws UserAlreadyExistsException;
    boolean userEmailExists(String email);
}
