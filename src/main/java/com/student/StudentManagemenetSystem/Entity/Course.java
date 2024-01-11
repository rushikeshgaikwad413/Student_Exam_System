package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.CourseDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String numberOfLession;
    private int studentIntake;
    private String faculty;


    public Course() {
    }

    public Course(CourseDto courseDto) {
        this.name= courseDto.getName();
        this.description= courseDto.getDescription();
        this.numberOfLession=courseDto.getNumberOfLession();
        this.studentIntake=courseDto.getStudentIntake();
        this.faculty=courseDto.getFaculty();
    }
}
