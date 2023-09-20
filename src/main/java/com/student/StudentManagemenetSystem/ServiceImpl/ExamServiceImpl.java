package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.ExamDto;
import com.student.StudentManagemenetSystem.Entity.Exam;
import com.student.StudentManagemenetSystem.Exception.invalidException;
import com.student.StudentManagemenetSystem.Repository.ExamRepository;
import com.student.StudentManagemenetSystem.Service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamRepository examRepository;


    @Override
    public void addQuestion(ExamDto examDto) {
        if (examDto.getQuestion()!=null){
            Exam exam = new Exam(examDto);
            examRepository.save(exam);
        }else {
            throw new invalidException("something wrong");
        }
    }
}
