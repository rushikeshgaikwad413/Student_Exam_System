package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.TeacherDto;
import com.student.StudentManagemenetSystem.Entity.Teacher;
import com.student.StudentManagemenetSystem.Exception.TeacherAllReadyExistException;
import com.student.StudentManagemenetSystem.Exception.teacherNotFound;
import com.student.StudentManagemenetSystem.Exception.teacherNotFoundByIdException;
import com.student.StudentManagemenetSystem.Repository.TeacherRepository;
import com.student.StudentManagemenetSystem.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherRepository teacherRepository;


    @Override
    public String addTeacher(TeacherDto teacherDto) {
        Teacher byEmail = teacherRepository.findByEmail(teacherDto.getEmail());
        if (byEmail == null){
            Teacher teacher =new Teacher(teacherDto);
            teacherRepository.save(teacher);
            return "teacher saved successfully";
        }else{
            throw new TeacherAllReadyExistException("teacher already exist");
        }

    }

    @Override
    public TeacherDto getById(int id) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if (byId.isPresent()){

            Teacher teacher = byId.get();
            TeacherDto teacherDto = new TeacherDto(teacher);
            return teacherDto;
        }else {
            throw new teacherNotFoundByIdException("Teacher Not Found By Id");
        }
    }

    @Override
    public String deleteTeacherById(int id) {
        Optional<Teacher> byId = teacherRepository.findById(id);
        if (byId.isPresent()){
            teacherRepository.deleteById(id);
            return "Student delete Successfully";
        }else {
            throw new teacherNotFound("Teacher Not Found");
        }
    }

    @Override
    public TeacherDto updateTeacherById(TeacherDto teacherDto) {
        Teacher byId = teacherRepository.findById(teacherDto.getId())
                    .orElseThrow(()-> new TeachNotFound("Teacher Not Found", HttpStatus.NOT_FOUND));


        if (teacherDto.getName() != null){
            byId.setName(teacherDto.getName());
        }

        if (teacherDto.getEmail() != null){
            byId.setName(teacherDto.getName());
        }

        if (teacherDto.getSub() !=null){
            byId.setSub(teacherDto.getSub());
        }

        teacherRepository.save(byId);
        return teacherDto;
    }


}
