package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.CourseDto;
import com.student.StudentManagemenetSystem.Exception.CourseNotFoundException;
import com.student.StudentManagemenetSystem.Exception.invalidException;
import com.student.StudentManagemenetSystem.Response.CourseNameResponse;
import com.student.StudentManagemenetSystem.Response.CourseResponse;
import com.student.StudentManagemenetSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")

public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("/addcourse")
    public ResponseEntity<?> addCourse (@RequestBody CourseDto courseDto){
        try{
            String string = courseService.addCourse(courseDto);
            return ResponseEntity.status(HttpStatus.OK).body(new CourseResponse("Course Added Successfully",string));
        } catch (invalidException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unsuccessful");
        }
    }

    @GetMapping("/getCourseByName")
    public ResponseEntity<?> getCoursebyName(@RequestParam String courseName){
        try {
            CourseNameResponse courseNameResponse = new CourseNameResponse("successfull");
            courseNameResponse.setResponse(courseService.getCourseByName(courseName));
            return ResponseEntity.status(HttpStatus.OK).body(courseNameResponse);
        } catch (CourseNotFoundException e) {
            CourseNameResponse courseNameResponse = new CourseNameResponse("unsuccessfull");
            courseNameResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(courseNameResponse);
        }
    }
}
