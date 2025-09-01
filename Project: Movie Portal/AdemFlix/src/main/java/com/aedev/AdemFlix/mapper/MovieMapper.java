package com.aedev.AdemFlix.mapper;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.entity.Movie;

public class MovieMapper {
    public static MovieDTO toDto(Movie movie) {
        if (movie == null) {
            return null;
        }

        return MovieDTO.builder()
                       .id(movie.getId())
                       .title(movie.getTitle())
                       .genre(movie.getGenre())
                       .directors(movie.getDirectors())
                       .summary(movie.getSummary())
                       .build();
    }

    public static Movie toEntity(MovieDTO movieDTO) {
        if (movieDTO == null) {
            return null;
        }

        return Movie.builder()
                    .id(movieDTO.getId())
                    .title(movieDTO.getTitle())
                    .genre(movieDTO.getGenre())
                    .directors(movieDTO.getDirectors())
                    .summary(movieDTO.getSummary())
                    .build();
    }
}
