package com.student.StudentManagemenetSystem.Repository;

import com.student.StudentManagemenetSystem.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByName(String userName);


    Optional<UserInfo> findByEmail(String username);
}
