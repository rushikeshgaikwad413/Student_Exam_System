package com.student.StudentManagemenetSystem.Response;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class StudentResponse2 {

    private String status;
    private String exception;
    private String message;

    public StudentResponse2(String message) {
        this.message = message;
    }
}
