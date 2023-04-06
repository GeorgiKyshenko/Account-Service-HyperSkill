package com.example.demo.repositories;

import com.example.demo.models.SignUpForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<SignUpForm, Long> {

    boolean existsByEmail(String email);

    Optional<SignUpForm> findByEmail(String email);
}
