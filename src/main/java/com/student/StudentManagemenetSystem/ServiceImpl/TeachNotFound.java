package com.student.StudentManagemenetSystem.ServiceImpl;

import org.springframework.http.HttpStatus;

public class TeachNotFound extends RuntimeException {

    private HttpStatus httpStatus;

    public TeachNotFound(String s, Object p1) {
    }
}
