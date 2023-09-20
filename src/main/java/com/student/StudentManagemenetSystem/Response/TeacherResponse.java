package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.TeacherDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TeacherResponse {

    private String status;
    private TeacherDto response;
    private String exception;

    public TeacherResponse(String status) {
        this.status = status;
    }

    public void setResponse(String s) {
    }
}
