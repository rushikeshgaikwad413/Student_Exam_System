package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.TeacherDto;
import com.student.StudentManagemenetSystem.Exception.*;
import com.student.StudentManagemenetSystem.Response.TeacherResponse;
import com.student.StudentManagemenetSystem.Response.TeacherUpdateResponse;
import com.student.StudentManagemenetSystem.Service.TeacherService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @PostMapping("/addTeacher")
    public ResponseEntity<String> addTeacher(@RequestBody TeacherDto teacherDto) {
        try {
            teacherService.addTeacher(teacherDto);
            return ResponseEntity.status(HttpStatus.OK).body("Teacher saved successfully");
        } catch (TeacherAllReadyExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Teacher already exists");
        }
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById (@RequestParam int id){
        try {
            TeacherResponse teacherResponse = new TeacherResponse("successful");
            teacherResponse.setResponse(String.valueOf(teacherService.getById(id)));
            return ResponseEntity.status(HttpStatus.OK).body(teacherResponse);
        } catch (teacherNotFoundByIdException e) {
            TeacherResponse teacherResponse = new TeacherResponse("unsuccessful");
            teacherResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teacherResponse);
        }
    }

    @DeleteMapping("/deleteTeacher")
    public ResponseEntity<?> deleteTeacher (@RequestParam int id){
        try{
            TeacherResponse teacherResponse = new TeacherResponse("successfully");
            teacherResponse.setResponse(String.valueOf(teacherService.deleteTeacherById(id)));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teacherResponse);
        }catch (teacherNotFound e){
            TeacherResponse teacherResponse = new TeacherResponse("unsuccessful");
            teacherResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teacherResponse);

        }
    }

    @PatchMapping("/updateTeacher")
    public ResponseEntity<?> updateTeacher (@RequestBody TeacherDto teacherDto){

        try{
            TeacherDto teacherDto1 = teacherService.updateTeacherById(teacherDto);
            TeacherUpdateResponse teacherUpdateResponse= new TeacherUpdateResponse("Success");
            teacherUpdateResponse.setStatus("successfull teacher update");
            teacherUpdateResponse.setResponse(teacherDto1);
            return ResponseEntity.status(HttpStatus.OK).body(teacherUpdateResponse);
        } catch (TeachernotFoundUpdateIdException e) {
            TeacherUpdateResponse teacherUpdateResponse = new TeacherUpdateResponse("UnSuccessfull");
            teacherUpdateResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(teacherUpdateResponse);
        }
    }

}
