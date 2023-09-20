package com.student.StudentManagemenetSystem.Dto;

import com.student.StudentManagemenetSystem.Entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {

    private int id;
    private String name;
    private String email;
    private String mobileNo;
    private String sub;

    public StudentDto(Student student) {
        this.id= student.getId();
        this.name= student.getName();
        this.email= student.getEmail();
        this.mobileNo=student.getMobileNo();
        this.sub=getSub();

    }
}
