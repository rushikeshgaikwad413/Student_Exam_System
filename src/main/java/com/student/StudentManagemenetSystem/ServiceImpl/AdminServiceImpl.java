package com.student.StudentManagemenetSystem.ServiceImpl;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import com.student.StudentManagemenetSystem.Entity.Admin;
import com.student.StudentManagemenetSystem.Exception.AdminAlreadyExistException;
import com.student.StudentManagemenetSystem.Exception.AdminEmailNotFound;
import com.student.StudentManagemenetSystem.Exception.AdminNotFoundException;
import com.student.StudentManagemenetSystem.Exception.adminNotfoundByIdException;
import com.student.StudentManagemenetSystem.Repository.AdminRepository;
import com.student.StudentManagemenetSystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public String addAdmin(AdminDto adminDto) {
        Admin byEmail = adminRepository.findByEmail(adminDto.getEmail());
        if (byEmail == null){
            Admin admin = new Admin(adminDto);
            adminRepository.save(admin);
            return "admin added succesfully";
        }else {
            throw new AdminAlreadyExistException("Admin Already Exist");
        }
    }

    @Override
    public AdminDto getAdminById(int id) {
        Optional<Admin> byId = adminRepository.findById(id);
        if (byId.isPresent()){
            Admin admin = byId.get();
            AdminDto adminDto = new AdminDto(admin);
            return adminDto;
        }else {
            throw new adminNotfoundByIdException("admin not found");
        }
    }

    @Override
    public AdminDto getAdminByEmail(String email) {
        Admin byEmail = adminRepository.findByEmail(email);
        if(byEmail == null){
            throw new AdminEmailNotFound("email does not exist");
        }
        return new AdminDto(byEmail);
    }

    @Override
    public AdminDto updateAdmin(AdminDto adminDto) {
        Admin byId = adminRepository.findById(adminDto.getId()).orElseThrow(()-> new AdminNotFoundException("Admin not found", HttpStatus.NOT_FOUND));

        if (byId.getName() != null){
            byId.setName(adminDto.getName());
        }

        if (byId.getEmail() != null){
            byId.setEmail(adminDto.getEmail());
        }

        adminRepository.save(byId);
        return adminDto;
    }

    @Override
    public Page<AdminDto> getAllAdmin(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        Page<Admin> all = adminRepository.findAll(pageRequest);
        return all.map(AdminDto::new);
    }


}
