package com.student.StudentManagemenetSystem.Service;

import com.student.StudentManagemenetSystem.Dto.AdminDto;
import org.springframework.data.domain.Page;

public interface AdminService {
    String addAdmin(AdminDto adminDto);

    AdminDto getAdminById(int id);

    AdminDto getAdminByEmail(String email);

    AdminDto updateAdmin(AdminDto adminDto);

    Page<AdminDto> getAllAdmin(int page, int pageSize);
}
