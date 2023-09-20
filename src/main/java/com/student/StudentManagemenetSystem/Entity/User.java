package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.UserDto;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;

    public User() {
    }

    public User(UserDto userDto) {
        this.email=userDto.getEmail();
        this.password= userDto.getPassword();
        this.id= userDto.getId();
    }
}
