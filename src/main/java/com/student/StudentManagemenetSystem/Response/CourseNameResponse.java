package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.CourseDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CourseNameResponse {

    private String status;
    private CourseDto response;

    private String exception;

    public CourseNameResponse(String status) {
        this.status = status;
    }
}
