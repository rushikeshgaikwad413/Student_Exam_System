package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import com.student.StudentManagemenetSystem.Exception.*;
import com.student.StudentManagemenetSystem.Response.StudentResponse;
import com.student.StudentManagemenetSystem.Response.StudentResponseE;
import com.student.StudentManagemenetSystem.Response.StudentUpdateResponse;
import com.student.StudentManagemenetSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto){
        try {
            String string = studentService.addStudent(studentDto);
            return ResponseEntity.status(HttpStatus.OK).body(string);
        }catch (UserAlreadyExistException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Student Already Exist");
        }catch (StudentNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Teacher Found");
        }
    }

    @GetMapping("/getByid")
    public ResponseEntity<?> getStudentById (@RequestParam int id){
        try {
            StudentResponse studentResponse = new StudentResponse("Successful");
            studentResponse.setResponse(String.valueOf(studentService.getUserbyId(id)));
            return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
        } catch (studentNotFoundByIdException e) {
            StudentResponse studentResponse = new StudentResponse("unsuccess");
            studentResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentResponse);
        }
    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity<?> deleteStudent(@RequestParam int id){
        try{
            StudentResponse studentResponse = new StudentResponse("successful");
            studentResponse.setResponse(studentService.deleteStudentById(id));
            return ResponseEntity.status(HttpStatus.OK).body(studentResponse);
        } catch (StudNotFoundException e) {
            StudentResponse studentResponse = new StudentResponse("unSuccessful");
            studentResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentResponse);
        }
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<?> updateStudent (@RequestBody StudentDto studentDto){
        try{
            StudentUpdateResponse studentUpdateResponse = new StudentUpdateResponse("success");
            studentUpdateResponse.setResponse(studentService.updateStudent(studentDto));
            studentUpdateResponse.setMessage("user update Successfully");
            return ResponseEntity.status(HttpStatus.OK).body(studentUpdateResponse);
        } catch (StudentUNotFound e) {
            StudentUpdateResponse studentUpdateResponse = new StudentUpdateResponse("unsuccessful");
            studentUpdateResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentUpdateResponse);
        }
    }

    @GetMapping("/getStudentbyGmail")
    public ResponseEntity<?> getStudentByEmail (@RequestParam String email){
        try {
            StudentResponseE studentResponseE= new StudentResponseE("succesfull");
            studentResponseE.setResponse(studentService.getStudentByEmail(email));
            return ResponseEntity.status(HttpStatus.OK).body(studentResponseE);
        }catch (emailNotExistException e){
            StudentResponseE studentResponseE = new StudentResponseE("unseccessful");
            studentResponseE.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentResponseE);
        }
    }

}

