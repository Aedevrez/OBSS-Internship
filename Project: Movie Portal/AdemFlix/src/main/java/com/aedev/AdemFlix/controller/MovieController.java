package com.aedev.AdemFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.entity.Director;
import com.aedev.AdemFlix.mapper.DirectorMapper;
import com.aedev.AdemFlix.service.impl.DirectorService;
import com.aedev.AdemFlix.service.impl.MovieService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/admin/movies")
public class MovieController {
    private final MovieService movieService;
    private final DirectorService directorService;

    @Autowired
    public MovieController(MovieService movieService, DirectorService directorService) {
        this.movieService = movieService;
        this.directorService = directorService;
    }

    @GetMapping
    public List<MovieDTO> findAllMovies() {
        return movieService.findAllMovies();
    }

    @GetMapping("/{id}")
    public MovieDTO getMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("/bydirector/{id}")
    public List<MovieDTO> getMovieByDirector(@PathVariable Long id) {
        return movieService.findMoviesByDirector_Id(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/create")
    public MovieDTO createMovie(@RequestBody MovieDTO movieDTO) {
        return movieService.saveMovie(movieDTO);
    }

    @PutMapping("/{id}")
    public MovieDTO updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        return movieService.updateMovie(id, movieDTO);
    }
    
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
    }
    
}
