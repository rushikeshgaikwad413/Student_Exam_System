package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.ExamDto;
import com.student.StudentManagemenetSystem.Exception.invalidException;
import com.student.StudentManagemenetSystem.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
