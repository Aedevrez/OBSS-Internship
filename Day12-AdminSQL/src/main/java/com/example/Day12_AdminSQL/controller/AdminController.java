package com.example.Day12_AdminSQL.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Day12_AdminSQL.dto.AdminDTO;
import com.example.Day12_AdminSQL.entity.Admin;
import com.example.Day12_AdminSQL.service.AdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/admins")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping()
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }

    @GetMapping("/{id}")
    public Admin findAdminById(@PathVariable Long id) {
        return adminService.findAdminById(id);
    }

    @PostMapping()
    public Admin createAdmin(@RequestBody AdminDTO adminDTO) {
        
        return adminService.createAdmin(adminDTO);
    }
    
    
    
}
