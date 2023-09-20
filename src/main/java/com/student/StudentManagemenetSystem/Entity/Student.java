package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String mobileNo;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    public Student() {
    }

    public Student(StudentDto studentDto,Teacher teacher) {
        this.name= studentDto.getName();
        this.email= studentDto.getEmail();
        this.mobileNo= studentDto.getMobileNo();
        this.id=studentDto.getId();
        this.teacher=teacher;
    }

}
