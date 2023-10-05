package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.StudentDto;
import com.student.StudentManagemenetSystem.Dto.UserDto;
import com.student.StudentManagemenetSystem.Entity.User;
import com.student.StudentManagemenetSystem.Exception.UserAlreadyExistException;
import com.student.StudentManagemenetSystem.Exception.UserNotFoundByEmailException;
import com.student.StudentManagemenetSystem.Exception.UserNotFoundbyIdException;
import com.student.StudentManagemenetSystem.Exception.somethingWentWrongException;
import com.student.StudentManagemenetSystem.Response.DUserResponse;
import com.student.StudentManagemenetSystem.Response.UserResponse;
import com.student.StudentManagemenetSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto) {
        try {
            String string = userService.addUser(userDto);
            return ResponseEntity.status(HttpStatus.OK).body(string);
        } catch (UserAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("user Already Exist");
        }
    }

//    @GetMapping("/getUserbyid")
//    public ResponseEntity<?> getUserById(@RequestParam int id){
//        try {
//            UserResponse userResponse = new UserResponse("successful");
//            userResponse.setResponse(userService.getUserById(id));
//            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
//        } catch (UserNotFoundbyIdException e) {
//            UserResponse userResponse = new UserResponse("unsuccessful");
//            userResponse.setException(String.valueOf(e));
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userResponse);
//        }
//    }




    @GetMapping("/getUserbyid")
    public ResponseEntity<?> getUserbyid(@RequestParam int id){
        try {
            UserResponse userResponse = new UserResponse("success");
            userResponse.setResponse(userService.getUserById(id));
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);

        }catch (UserNotFoundbyIdException e){
            UserResponse userResponse = new UserResponse("unsuccess");
            userResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userResponse);
        }
    }

    @GetMapping("/getUserByEmail")
    public ResponseEntity<?> findUserByEmail(@RequestParam String email){
        try {
            UserResponse userResponse = new UserResponse("success");
            userResponse.setResponse(userService.getUserByEmail(email));
            return ResponseEntity.status(HttpStatus.OK).body(userResponse);
        } catch (UserNotFoundByEmailException e) {
            UserResponse userResponse =new UserResponse("Unsuccess");
            userResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userResponse);
        }
    }

    @DeleteMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam int id){
        try {
            String string = userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new DUserResponse("success", string));
        } catch (UserNotFoundbyIdException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new DUserResponse("unsuccess","user not found"));
        }
    }

}
