package com.aedev.AdemFlix.service;

import java.util.List;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.dto.UserDTO;

public interface IUserService {
    UserDTO saveUser(UserDTO userDTO);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long id);

    UserDTO findByUsername(String username);

    List<MovieDTO> fetchWatchlistOfUser(UserDTO userDTO);

    List<MovieDTO> fetchFavouritesOfUser(UserDTO userDTO);

    MovieDTO addMovieToWatchlist(UserDTO userDTO, MovieDTO movieDTO);

    MovieDTO addMovieToFavourites(Long userId, Long movieId);

    UserDTO updateUser(Long id, UserDTO userDTO);

    UserDTO deleteUser(Long id);
}
