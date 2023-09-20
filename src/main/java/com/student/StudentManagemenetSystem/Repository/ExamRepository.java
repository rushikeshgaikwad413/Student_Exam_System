package com.student.StudentManagemenetSystem.Repository;

import com.student.StudentManagemenetSystem.Entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository <Exam, Integer> {

    void findByQuestion(String question);
}
