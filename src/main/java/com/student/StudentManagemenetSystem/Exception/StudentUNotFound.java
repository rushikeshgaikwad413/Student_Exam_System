package com.student.StudentManagemenetSystem.Exception;

import org.springframework.http.HttpStatus;

public class StudentUNotFound extends RuntimeException {

    private HttpStatus httpStatus;

    private String message;

    public StudentUNotFound(String message,HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
