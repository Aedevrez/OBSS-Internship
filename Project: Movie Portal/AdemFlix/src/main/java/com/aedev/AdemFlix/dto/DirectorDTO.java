package com.aedev.AdemFlix.dto;

import java.util.List;

import com.aedev.AdemFlix.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDTO {
    private Long id;
    private String name;
    private String surname;
    private String fullName;
    private String email;
    private List<Movie> movies;
}
