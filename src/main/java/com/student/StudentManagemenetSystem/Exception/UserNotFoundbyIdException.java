package com.student.StudentManagemenetSystem.Exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundbyIdException extends RuntimeException {

    private HttpStatus httpStatus;

    public UserNotFoundbyIdException(String message) {
        super(message);
    }

    public UserNotFoundbyIdException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
