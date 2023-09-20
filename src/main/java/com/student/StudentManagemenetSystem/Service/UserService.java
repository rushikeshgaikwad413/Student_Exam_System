package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.UserDto;
import com.student.StudentManagemenetSystem.Entity.User;

public interface UserService {
    String addUser(UserDto userDto);


    UserDto getUserById(int id);

    UserDto getUserByEmail(String email);
}
