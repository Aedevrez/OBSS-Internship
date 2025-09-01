package com.aedev.AdemFlix.mapper;

import com.aedev.AdemFlix.dto.DirectorDTO;
import com.aedev.AdemFlix.entity.Director;

public class DirectorMapper {
    public static DirectorDTO toDto(Director director) {
        if (director == null) {
            return null;
        }

        return DirectorDTO.builder()
                       .id(director.getId())
                       .name(director.getName())
                       .surname(director.getSurname())
                       .fullName(director.getName() + " " + director.getSurname())
                       .email(director.getEmail())
                       .movies(director.getMovies())
                       .build();
    }

    public static Director toDirector(DirectorDTO directorDTO) {
        if (directorDTO == null) {
            return null;
        }

        return Director.builder()
                       .id(directorDTO.getId())
                       .name(directorDTO.getName())
                       .surname(directorDTO.getSurname())
                       .email(directorDTO.getEmail())
                       .movies(directorDTO.getMovies())
                       .build();
    }
}
