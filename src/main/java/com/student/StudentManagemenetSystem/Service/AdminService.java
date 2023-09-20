package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.AdminDto;

public interface AdminService {
    String addAdmin(AdminDto adminDto);

    AdminDto getAdminById(int id);

}
