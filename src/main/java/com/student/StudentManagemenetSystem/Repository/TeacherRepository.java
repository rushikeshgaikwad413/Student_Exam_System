package com.student.StudentManagemenetSystem.Repository;

import com.student.StudentManagemenetSystem.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findByEmail(String email);

    Teacher findBySub(String sub);
}
