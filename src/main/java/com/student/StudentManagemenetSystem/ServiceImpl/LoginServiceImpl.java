package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.UserDto;
import com.student.StudentManagemenetSystem.Entity.User;
import com.student.StudentManagemenetSystem.Exception.somethingWentWrongException;
import com.student.StudentManagemenetSystem.Repository.LoginRepository;
import com.student.StudentManagemenetSystem.Repository.UserRepository;
import com.student.StudentManagemenetSystem.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserRepository loginRepository;

    @Override
    public User loginUser(UserDto userDto) {
        User byEmail = loginRepository.findByEmail(userDto.getEmail());
        if (byEmail != null && byEmail.getPassword().equals(userDto.getPassword())) {
            return byEmail;
        } else {
            throw new somethingWentWrongException("Invalid email and password");
        }
    }
}

