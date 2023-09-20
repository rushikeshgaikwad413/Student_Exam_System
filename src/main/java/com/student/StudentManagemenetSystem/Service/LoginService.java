package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.UserDto;
import com.student.StudentManagemenetSystem.Entity.User;

public interface LoginService {

    User loginUser(UserDto userDto);
}
