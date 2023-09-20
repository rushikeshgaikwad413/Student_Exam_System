package com.student.StudentManagemenetSystem.Entity;

import com.student.StudentManagemenetSystem.Dto.ExamDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    public Exam(ExamDto examDto) {
        this.question=examDto.getQuestion();
        this.option1=examDto.getOption1();
        this.option2=examDto.getOption2();
        this.option3=examDto.getOption3();
        this.option4=examDto.getOption4();
        this.answer=examDto.getAnswer();
    }
}
