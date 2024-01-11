package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.UserDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Data
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;

    @ManyToMany(mappedBy = "users")
    private List<Admin> admins;

    public User() {
    }

    public User(UserDto userDto) {
        this.email=userDto.getEmail();
        this.password= userDto.getPassword();
        this.id= userDto.getId();
    }
}
