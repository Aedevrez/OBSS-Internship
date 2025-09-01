package com.example.Day12_AdminSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Day12_AdminSQL.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    
}
