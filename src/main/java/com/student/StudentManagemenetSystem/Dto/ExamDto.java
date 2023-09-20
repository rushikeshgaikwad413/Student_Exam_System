package com.student.StudentManagemenetSystem.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDto {

    private int id;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

}
