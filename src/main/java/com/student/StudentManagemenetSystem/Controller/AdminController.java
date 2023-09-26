package com.student.StudentManagemenetSystem.Controller;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import com.student.StudentManagemenetSystem.Exception.*;
import com.student.StudentManagemenetSystem.Response.AdminResponse;
import com.student.StudentManagemenetSystem.Response.AdminUpdateResponse;
import com.student.StudentManagemenetSystem.Response.GetAllAdminResponse;
import com.student.StudentManagemenetSystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    @GetMapping("/getAdminByEmail")
    public ResponseEntity<?> getAdminByEmailId (@RequestParam String email){
        try {
            adminService.getAdminByEmail(email);
            AdminResponse adminResponse = new AdminResponse("Success");
            adminResponse.setResponse(adminService.getAdminByEmail(email));
            return ResponseEntity.status(HttpStatus.OK).body(adminResponse);
        } catch (AdminEmailNotFound e) {
            AdminResponse adminResponse = new AdminResponse("unsuccessfull");
            adminResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(adminResponse);
        }
    }

    @PutMapping("/updateAdmin")
    public ResponseEntity<?> updateAdmin(@RequestBody AdminDto adminDto){
        try {
            AdminUpdateResponse adminUpdateResponse = new AdminUpdateResponse("successful");
            adminUpdateResponse.setResponse( adminService.updateAdmin(adminDto));
            adminUpdateResponse.setMessage("admin update Succesfully");
            return ResponseEntity.status(HttpStatus.OK).body(adminUpdateResponse);
        } catch (AdminNotFoundException e) {
            AdminUpdateResponse adminUpdateResponse = new AdminUpdateResponse("unsuccessful");
            adminUpdateResponse.setException(String.valueOf(e));
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(adminUpdateResponse);
        }
    }

    @GetMapping("/listOfAdmin")
    public ResponseEntity<?> getAllAdmin(@RequestParam (defaultValue = "0")int page, @RequestParam (defaultValue = "10")int pageSize){
        try {
            Page<AdminDto> allAdmin = adminService.getAllAdmin(page, pageSize);
            return ResponseEntity.status(HttpStatus.OK).body(allAdmin);
        }catch (GetAllAdminException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("field to get data");
        }
    }

}
