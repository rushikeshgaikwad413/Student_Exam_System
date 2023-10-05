package com.student.StudentManagemenetSystem.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RQuestionDto {
    private String status;
    private String message;

    public RQuestionDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
