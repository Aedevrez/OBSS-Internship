package com.aedev.AdemFlix.service;

import java.util.List;

import com.aedev.AdemFlix.dto.DirectorDTO;

public interface IDirectorService {
    DirectorDTO saveDirector(DirectorDTO directorDTO);

    List<DirectorDTO> findAllDirectors();

    DirectorDTO findDirectorById(Long id);

    List<DirectorDTO> findDirectorByName(String name);

    DirectorDTO updateDirector(Long id, DirectorDTO directorDTO);

    void deleteDirector(Long id);
}
