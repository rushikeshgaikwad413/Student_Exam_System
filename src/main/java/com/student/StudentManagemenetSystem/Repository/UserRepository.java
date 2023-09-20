package com.student.StudentManagemenetSystem.Repository;

import com.student.StudentManagemenetSystem.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
