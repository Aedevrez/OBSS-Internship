package com.example.Day12_AdminSQL.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Day12_AdminSQL.dto.AdminDTO;
import com.example.Day12_AdminSQL.entity.Admin;
import com.example.Day12_AdminSQL.repository.AdminRepository;
import com.example.Day12_AdminSQL.service.AdminService;

@Service
public class BasicAdminService implements AdminService{
    private final AdminRepository adminRepository;

    @Autowired
    public BasicAdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin createAdmin(AdminDTO adminDTO) {
        Admin newAdmin = Admin.builder().name(adminDTO.getName()).build();
        return this.adminRepository.save(newAdmin);
    }

    @Override
    public Admin findAdminById(Long id) {
        return adminRepository.findById(id).orElse(null);
    }
}
