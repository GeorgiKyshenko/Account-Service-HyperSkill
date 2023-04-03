package com.example.demo.services;

import com.example.demo.models.DTOs.SignUpResponse;
import com.example.demo.models.SignUpForm;

public interface RegistrationService {

    SignUpResponse register(SignUpForm sigUp);
}
