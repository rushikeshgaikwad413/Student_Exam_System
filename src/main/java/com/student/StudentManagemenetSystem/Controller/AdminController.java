package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import com.student.StudentManagemenetSystem.Exception.AdminAlreadyExistException;
import com.student.StudentManagemenetSystem.Exception.adminNotfoundByIdException;
import com.student.StudentManagemenetSystem.Response.AdminResponse;
import com.student.StudentManagemenetSystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/addAdmin")
    public ResponseEntity<?> addAdmin (@RequestBody AdminDto adminDto){
        try{
            String string = adminService.addAdmin(adminDto);
            return ResponseEntity.status(HttpStatus.OK).body(string);
        } catch (AdminAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Admin Alredy Exist");
        }
    }

    @GetMapping("/getAdminById")
    public ResponseEntity<?> getAdminById (@RequestParam int id){
        try{
            AdminResponse adminResponse= new AdminResponse("successfull");
            adminResponse.setResponse(adminService.getAdminById(id));
            return ResponseEntity.status(HttpStatus.OK).body(adminResponse);
        } catch (adminNotfoundByIdException e) {
            AdminResponse adminResponse= new AdminResponse("unsuccessfull");
            adminResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(adminResponse);
        }
    }


}
