package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class Admin {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;


    public Admin() {
    }

    public Admin(AdminDto adminDto) {
        this.name= adminDto.getName();
        this.email= adminDto.getEmail();
        this.id= adminDto.getId();
    }
}
