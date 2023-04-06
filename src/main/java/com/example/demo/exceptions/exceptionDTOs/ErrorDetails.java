package com.example.demo.exceptions.exceptionDTOs;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ErrorDetails {

    LocalDateTime timestamp;
    int code;
    String error;
    String message;
    String path;

}
