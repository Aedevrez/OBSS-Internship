package com.aedev.AdemFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aedev.AdemFlix.dto.DirectorDTO;
import com.aedev.AdemFlix.service.impl.DirectorService;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping
    public List<DirectorDTO> findAllDirectors() {
        return directorService.findAllDirectors();
    }
    
    @GetMapping("/{id}")
    public DirectorDTO getDirectorById(@PathVariable Long id) {
        return directorService.findDirectorById(id);
    }

    @PostMapping("/create")
    public DirectorDTO createDirector(@RequestBody DirectorDTO directorDTO) {
        return directorService.saveDirector(directorDTO);
    }

    @PutMapping("/{id}")
    public DirectorDTO updateDirector(@PathVariable Long id, @RequestBody DirectorDTO directorDTO) {
        return directorService.updateDirector(id, directorDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteDirector(@PathVariable Long id) {
        directorService.deleteDirector(id);
    }
}
