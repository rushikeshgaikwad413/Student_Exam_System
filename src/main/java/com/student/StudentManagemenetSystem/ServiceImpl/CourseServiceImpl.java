package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.CourseDto;
import com.student.StudentManagemenetSystem.Entity.Course;
import com.student.StudentManagemenetSystem.Exception.CourseNotFoundException;
import com.student.StudentManagemenetSystem.Exception.invalidException;
import com.student.StudentManagemenetSystem.Repository.CourseRepository;
import com.student.StudentManagemenetSystem.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    @Override
    public String addCourse(CourseDto courseDto) {
        if (courseDto.getName()  !=null){
            Course course = new Course(courseDto);
            courseRepository.save(course);
            return "course Added";
        }else {
            throw new invalidException("something wrong");
        }

    }

    @Override
    public CourseDto getCourseByName(String courseName) {
        Course byName = courseRepository.findByName(courseName);
        if (byName == null){
            throw new CourseNotFoundException("course not found");
        }
        return new CourseDto(byName);
    }

}
