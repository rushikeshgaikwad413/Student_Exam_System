package com.student.StudentManagemenetSystem.Dto;

import com.student.StudentManagemenetSystem.Entity.Admin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {

    private int id;
    private String name;
    private String email;


    public AdminDto(Admin admin) {
        this.id= admin.getId();
        this.name= admin.getName();
        this.email= admin.getEmail();
    }
}
