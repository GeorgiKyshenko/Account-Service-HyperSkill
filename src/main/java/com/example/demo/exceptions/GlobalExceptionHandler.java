package com.example.demo.exceptions;

import com.example.demo.exceptions.exceptionDTOs.ErrorDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> userNotFound(UserAlreadyExistsException exception, WebRequest request) {
        log.info("Exception: {}, Request path: {}",exception.getClass().getSimpleName(), request.getDescription(false));
        return ResponseEntity.badRequest().body(ErrorDetails.builder().timestamp(LocalDateTime.now())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .error("Bad Request")
                        .message("User Exists!")
                        .path("/api/auth/signup")
                .build());
    }
}
