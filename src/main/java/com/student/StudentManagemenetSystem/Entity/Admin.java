package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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

    @ManyToMany
    @JoinTable(name= "Admin_user", joinColumns = {@JoinColumn(name="id"  )}, inverseJoinColumns = {@JoinColumn(name = "Aid")})
    private List<User> users;



    public Admin() {
    }

    public Admin(AdminDto adminDto) {
        this.name= adminDto.getName();
        this.email= adminDto.getEmail();
        this.id= adminDto.getId();
    }
}
