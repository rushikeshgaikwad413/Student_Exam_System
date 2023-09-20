package com.student.StudentManagemenetSystem.Repository.Repository;

import com.student.StudentManagemenetSystem.Entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Integer> {
}
