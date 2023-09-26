package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import lombok.Data;

@Data
public class AdminUpdateResponse {

    private String message;
    private AdminDto response;

    private String exception;

    public AdminUpdateResponse(String message) {
        this.message = message;
    }
}
