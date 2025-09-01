package com.aedev.AdemFlix.service;

import java.util.List;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.entity.Director;

public interface IMovieService {
    MovieDTO saveMovie(MovieDTO movieDTO);

    List<MovieDTO> findAllMovies();

    MovieDTO findMovieById(Long id);

    List<MovieDTO> findMoviesByGenre(String genre);

    List<MovieDTO> findMoviesByDirector_Id(Long directorId);

    MovieDTO updateMovie(Long id, MovieDTO movieDTO);

    void deleteMovie(Long id);
}
