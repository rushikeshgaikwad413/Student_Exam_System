package com.student.StudentManagemenetSystem.Response;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class GetAllAdminResponse {

    private String message;
    private Page<AdminDto> response;

    private String exception;

    public GetAllAdminResponse(String message) {
        this.message = message;
    }


}
