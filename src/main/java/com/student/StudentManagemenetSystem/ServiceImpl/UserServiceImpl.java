package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.UserDto;
import com.student.StudentManagemenetSystem.Entity.User;
import com.student.StudentManagemenetSystem.Exception.*;
import com.student.StudentManagemenetSystem.Repository.UserRepository;
import com.student.StudentManagemenetSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String addUser(UserDto userDto) {
        User byEmail = userRepository.findByEmail(userDto.getEmail());
        if (byEmail == null) {
            User user = new User(userDto);
            userRepository.save(user);
            return "user save successfully";
        } else {
            throw new UserAlreadyExistException("User Already Exist");
        }
    }

    @Override
    public UserDto getUserById(int id) {

        Optional<User> byId = userRepository.findById(id);
        if(byId.isEmpty()){
            throw new UserNotFoundbyIdException("users details not found by id");
        }
        return new UserDto(byId.get());
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User byEmail = userRepository.findByEmail(email);
        if (byEmail == null){
            throw new UserNotFoundByEmailException("Email Not Exist");
        }
        return new UserDto(byEmail);
    }

    @Override
    public String deleteUserById(int id) {
        Optional<User> byId = userRepository.findById(id);
        if (byId == null){
            throw new UserNotFoundbyIdException("id not found" + id);
        }
        userRepository.deleteById(id);
        return "user deleted successfully"+ id;
    }


//    @Override
//    public UserDto getUserById(int id) {
//        Optional<User> byId = userRepository.findById(id);
//        if (byId.isPresent()) {
//
//            User user = byId.get();
//            UserDto userDto = new UserDto(user);
//            return userDto;
//        } else {
//            throw new UserNotFoundbyIdException("user not found");
//        }
//
//    }
}
