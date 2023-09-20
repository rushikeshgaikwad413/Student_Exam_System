package com.student.StudentManagemenetSystem.Dto;

import com.student.StudentManagemenetSystem.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private int id;

    private String email;
    private String password;

    public UserDto(User user) {
        this.email= user.getEmail();
        this.password= user.getPassword();
        this.id= user.getId();
    }
}
