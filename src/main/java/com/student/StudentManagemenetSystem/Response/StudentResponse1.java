package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class StudentResponse1 {

    private String status;
    private StudentDto response;

    public StudentResponse1(String status) {
        this.status = status;
    }
}
