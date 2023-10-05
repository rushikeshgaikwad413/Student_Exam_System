package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.ExamDto;
import com.student.StudentManagemenetSystem.Dto.RQuestionDto;
import com.student.StudentManagemenetSystem.Exception.QuestionNotFoundException;
import com.student.StudentManagemenetSystem.Exception.invalidException;
import com.student.StudentManagemenetSystem.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exam")

public class ExamController {

    @Autowired
    ExamService examService;

    @PostMapping("/addQuestion")
    public ResponseEntity<?> addQuestion (@RequestBody ExamDto examDto){

        try{
            examService.addQuestion(examDto);
            return ResponseEntity.status(HttpStatus.OK).body("Successful");
        } catch (invalidException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsuccessful");
        }
    }

    @DeleteMapping("/deleteQuestion")
    public ResponseEntity<?> deleteQuestion (@RequestParam int id){
        try {
            String string = examService.deleteQuestionById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new RQuestionDto("success",string));
        } catch (QuestionNotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new RQuestionDto("unsuccess","question not found"));
        }
    }
}
