package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import com.student.StudentManagemenetSystem.Entity.Student;
import com.student.StudentManagemenetSystem.Entity.Teacher;
import com.student.StudentManagemenetSystem.Exception.*;
import com.student.StudentManagemenetSystem.Repository.StudentRepository;
import com.student.StudentManagemenetSystem.Repository.TeacherRepository;
import com.student.StudentManagemenetSystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String addStudent(StudentDto studentDto) {
        Student byEmail = studentRepository.findByEmail(studentDto.getEmail());
        Teacher bySub = teacherRepository.findBySub(studentDto.getSub());
        if (byEmail == null){
            if (bySub!=null) {
                Student student = new Student(studentDto,bySub);
                studentRepository.save(student);
                return "student save successfully";
            }else {
                throw new TeacherNotFoundException("Teacher Not Found");
            }
        }else {
            throw new UserAlreadyExistException("student already exist");
        }
    }

    @Override
    public StudentDto getUserbyId(int id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()){

            Student student =byId.get();
            StudentDto studentDto =new StudentDto(student);
            return studentDto;
        }else {
            throw new studentNotFoundByIdException("student Not found");
        }
    }


    @Override
    public String deleteStudentById(int id) {
        Optional<Student> byId = studentRepository.findById(id);
        if (byId.isPresent()){
            studentRepository.deleteById(id);
            return "Student deleted successfully";
        }else {
            throw new StudNotFoundException("Student Not Found ");
        }
    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student byId = studentRepository.findById(studentDto.getId())
                .orElseThrow(()-> new StudentUNotFound ("student not found", HttpStatus.NOT_FOUND));

        if (studentDto.getName() !=null) {
            byId.setName(studentDto.getName());
        }
        if (studentDto.getName() !=null){
            byId.setEmail(studentDto.getEmail());
        }
        if (studentDto.getMobileNo() !=null){
            byId.setMobileNo(studentDto.getMobileNo());
        }

        studentRepository.save(byId);
        return studentDto;
    }

    @Override
    public StudentDto getStudentByEmail(String email) {
        Student byEmail = studentRepository.findByEmail(email);
        if (byEmail == null ){
            throw new emailNotExistException("Email Not Exist");
        }else {
            return new StudentDto(byEmail);
        }
    }

}
