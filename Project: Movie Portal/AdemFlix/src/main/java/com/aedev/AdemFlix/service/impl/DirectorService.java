package com.aedev.AdemFlix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aedev.AdemFlix.dto.DirectorDTO;
import com.aedev.AdemFlix.entity.Director;
import com.aedev.AdemFlix.mapper.DirectorMapper;
import com.aedev.AdemFlix.repository.DirectorRepository;
import com.aedev.AdemFlix.service.IDirectorService;

@Service
public class DirectorService implements IDirectorService{
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    @Override
    public DirectorDTO saveDirector(DirectorDTO directorDTO) {
        Director director = DirectorMapper.toDirector(directorDTO);
        return DirectorMapper.toDto(directorRepository.save(director));
    }

    @Override
    public List<DirectorDTO> findAllDirectors() {
        return directorRepository.findAll().stream()
                                           .map(DirectorMapper::toDto)
                                           .toList();
    }

    @Override
    public DirectorDTO findDirectorById(Long id) {
        return directorRepository.findById(id).map(DirectorMapper::toDto).orElse(null);
    }

    @Override
    public List<DirectorDTO> findDirectorByName(String name) {
        return directorRepository.findAll().stream()
                                        .map(DirectorMapper::toDto)
        .filter(dto -> dto.getFullName().contains(name))
                                        .toList();
    }

    @Override
    public DirectorDTO updateDirector(Long id, DirectorDTO directorDTO) {
        var directorOptional = directorRepository.findById(id);

        if (directorOptional.isEmpty()) {
            return null;
        }

        Director director = directorOptional.get();
        director.setName(directorDTO.getName());
        director.setSurname(directorDTO.getSurname());
        director.setEmail(directorDTO.getEmail());
        director.setMovies(directorDTO.getMovies());
        return DirectorMapper.toDto(directorRepository.save(director));
    }

    @Override
    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);;
    }
    
}
