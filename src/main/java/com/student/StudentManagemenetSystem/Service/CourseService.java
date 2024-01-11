package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.CourseDto;

public interface CourseService {
    String addCourse(CourseDto courseDto);

    CourseDto getCourseByName(String courseName);
}
