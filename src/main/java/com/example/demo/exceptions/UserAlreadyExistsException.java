package com.example.demo.exceptions;

public class UserAlreadyExistsException extends BussinessException {

    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
