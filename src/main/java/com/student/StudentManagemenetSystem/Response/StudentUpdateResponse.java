package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import lombok.Data;

@Data
public class StudentUpdateResponse {

    private String message;
    private String status;
    private String exception;
    private StudentDto response;

    public StudentUpdateResponse(String message) {
        this.message = message;
    }
}
