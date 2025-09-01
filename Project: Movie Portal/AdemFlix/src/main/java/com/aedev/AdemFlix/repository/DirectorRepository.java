package com.aedev.AdemFlix.repository;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.entity.Director;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long>{
    
}
