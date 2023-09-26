package com.student.StudentManagemenetSystem.Exception;

import org.springframework.http.HttpStatus;

public class AdminNotFoundException extends RuntimeException {

    private HttpStatus httpStatus;

    private String message;

    public AdminNotFoundException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public AdminNotFoundException(String s, HttpStatus httpStatus) {
    }
}
