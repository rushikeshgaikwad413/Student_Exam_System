package com.student.StudentManagemenetSystem.Dto;

import com.student.StudentManagemenetSystem.Entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private int id;

    private String name;
    private String description;
    private String numberOfLession;
    private int studentIntake;
    private String faculty;

    public CourseDto(Course byName) {
    }
}
