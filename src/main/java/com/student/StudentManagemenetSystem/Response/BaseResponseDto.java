package com.student.StudentManagemenetSystem.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponseDto {

    private String code;
    private String message;

    public BaseResponseDto(String message) {
        this.message = message;
    }

}
