package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.UserDto;
import com.student.StudentManagemenetSystem.Entity.User;
import com.student.StudentManagemenetSystem.Exception.somethingWentWrongException;
import com.student.StudentManagemenetSystem.Service.LoginService;
import com.student.StudentManagemenetSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class loginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/loginUser")
    public ResponseEntity<?> loginUser(@RequestBody UserDto userDto){
        try{
            User user = loginService.loginUser(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid email and password");
        }
    }
}
