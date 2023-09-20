package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import com.student.StudentManagemenetSystem.Dto.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserResponse {

    private String status;
    private UserDto response;
    private String exception;


    public UserResponse(String status) {
        this.status = status;
    }
}
