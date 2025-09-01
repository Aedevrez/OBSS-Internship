package com.example.Day12_AdminSQL.service;

import java.util.List;

import com.example.Day12_AdminSQL.dto.AdminDTO;
import com.example.Day12_AdminSQL.entity.Admin;

public interface AdminService {
    List<Admin> getAdmins();
    Admin createAdmin(AdminDTO adminDTO);
    Admin findAdminById(Long id);
}
