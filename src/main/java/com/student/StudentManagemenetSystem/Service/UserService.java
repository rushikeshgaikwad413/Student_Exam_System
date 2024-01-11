package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.UserDto;

public interface UserService {
    String addUser(UserDto userDto);

    UserDto getUserById(int id);

    UserDto getUserByEmail(String email);

    String deleteUserById(int id);
}
