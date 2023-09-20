package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.TeacherDto;

public interface TeacherService {
    String addTeacher(TeacherDto teacherDto);

    TeacherDto getById(int id);

    String deleteTeacherById(int id);

    TeacherDto updateTeacherById(TeacherDto teacherDto);

}
