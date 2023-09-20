package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.TeacherDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Getter
@Setter

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String sub;

    public Teacher() {
    }

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Student> studentList=new ArrayList<>();

    public Teacher(TeacherDto teacherDto) {
        this.name= teacherDto.getName();
        this.email=teacherDto.getEmail();
        this.sub= teacherDto.getSub();
    }
}
