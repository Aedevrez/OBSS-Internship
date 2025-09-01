package com.aedev.AdemFlix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.entity.Director;
import com.aedev.AdemFlix.entity.Movie;
import com.aedev.AdemFlix.mapper.MovieMapper;
import com.aedev.AdemFlix.repository.MovieRepository;
import com.aedev.AdemFlix.service.IMovieService;

@Service
public class MovieService implements IMovieService{
    private final MovieRepository movieRepository;
    //continue after implementing mappers

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO saveMovie(MovieDTO movieDTO) {
        Movie movie = MovieMapper.toEntity(movieDTO);
        return MovieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public List<MovieDTO> findAllMovies() {
        return movieRepository.findAll().stream()
                                        .map(MovieMapper::toDto)
                                        .toList();
    }

    @Override
    public MovieDTO findMovieById(Long id) {
        return movieRepository.findById(id).map(MovieMapper::toDto).orElse(null);
    }

    @Override
    public List<MovieDTO> findMoviesByGenre(String genre) {
        return movieRepository.findAll().stream()
                                        .filter(movie -> movie.getGenre().equals(genre))
                                        .map(MovieMapper::toDto)
                                        .toList();
    }

    @Override
    public List<MovieDTO> findMoviesByDirector_Id(Long directorId) {
        /*return movieRepository.findAll().stream()
                                        .filter(movie -> movie.getDirectors().contains(director))
                                        .map(MovieMapper::toDto)
                                        .toList();*/
        
        return movieRepository.findMoviesByDirectors_Id(directorId).stream()
            .map(MovieMapper::toDto)
            .toList();

    }

    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        var movieOptional = movieRepository.findById(id);
        if (movieOptional.isEmpty()) {
            return null;
        }

        Movie movie = movieOptional.get();
        movie.setTitle(movieDTO.getTitle());
        movie.setGenre(movieDTO.getGenre());
        movie.setSummary(movieDTO.getSummary());
        movie.setDirectors(movieDTO.getDirectors());
        return MovieMapper.toDto(movieRepository.save(movie));
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
