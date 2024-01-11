package com.student.StudentManagemenetSystem.Repository;

import com.student.StudentManagemenetSystem.Entity.Student;
import com.student.StudentManagemenetSystem.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findByEmail(String email);

}
