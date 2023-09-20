package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.TeacherDto;
import lombok.Data;

@Data
public class TeacherUpdateResponse {

    private String message;
    private String status;
    private String exception;
    private TeacherDto response;

    public TeacherUpdateResponse(String message) {
        this.message = message;
    }
}
