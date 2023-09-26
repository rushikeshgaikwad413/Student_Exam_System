package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.StudentDto;

public interface StudentService {


    String addStudent(StudentDto studentDto);

    StudentDto getUserbyId(int id);


    String deleteStudentById(int id);

    StudentDto updateStudent(StudentDto studentDto);

    StudentDto getStudentByEmail(String email);

    StudentDto getStudentById(int id);
}
