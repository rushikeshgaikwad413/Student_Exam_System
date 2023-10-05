package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentResponse {

    private String status;
    private StudentDto response;
    private String exception;


    public StudentResponse(String status) {
        this.status = status;
    }


    public void setResponse(String s) {
    }
}




