package com.student.StudentManagemenetSystem.Repository;

import com.student.StudentManagemenetSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository {

    User findByEmail(String email);
}
