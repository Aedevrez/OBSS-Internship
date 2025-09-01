package com.aedev.AdemFlix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    @Query("SELECT DISTINCT m FROM Movie m JOIN FETCH m.directors d WHERE d.id = :id")
    List<Movie> findMoviesByDirectors_Id(Long id);
}
