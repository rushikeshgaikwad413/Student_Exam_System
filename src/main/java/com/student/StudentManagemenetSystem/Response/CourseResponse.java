package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.CourseDto;
import lombok.*;

@Data
@Getter
@Setter
public class CourseResponse {
    private String status;
    private String message;
    private CourseDto response;


    public CourseResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

}
