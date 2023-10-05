package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.UserDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class DUserResponse {

    private String status;
    private String message;


    public DUserResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
