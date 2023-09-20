package com.student.StudentManagemenetSystem.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class MessageDTO {
    private String phoneNumberId;
    private String bearerToken;
    private String targetPhoneNumber;
    private String message;

}
