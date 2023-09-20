package com.student.StudentManagemenetSystem.Dto;

import com.student.StudentManagemenetSystem.Entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDto {
    private int id;

    private String name;
    private String email;
    private String sub;

    public TeacherDto(Teacher teacher) {
        this.id=teacher.getId();
        this.name=teacher.getName();
        this.email=teacher.getEmail();
        this.sub=getSub();
    }
}
