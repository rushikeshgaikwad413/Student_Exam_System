package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class AdminResponse {

    private String status;
    private AdminDto response;
    private String exception;

    public AdminResponse(String status) {
        this.status = status;
    }

}
