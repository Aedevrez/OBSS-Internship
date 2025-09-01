package com.aedev.AdemFlix.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.dto.UserDTO;
import com.aedev.AdemFlix.entity.User;
import com.aedev.AdemFlix.mapper.MovieMapper;
import com.aedev.AdemFlix.mapper.UserMapper;
import com.aedev.AdemFlix.repository.MovieRepository;
import com.aedev.AdemFlix.repository.UserRepository;
import com.aedev.AdemFlix.service.IUserService;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public UserService(UserRepository userRepository, MovieRepository movieRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<UserDTO> findAllUsers() {
        return userRepository.findAll().stream()
                                        .map(UserMapper::toDto)
                                        .toList();
    }

    @Override
    public UserDTO findUserById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDto).orElse(null);
    }

    @Override
    public List<MovieDTO> fetchWatchlistOfUser(UserDTO userDTO) {
        return userDTO.getWatchlist();
    }

    @Override
    public List<MovieDTO> fetchFavouritesOfUser(UserDTO userDTO) {
        return userDTO.getFavourites();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
        var userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRoles(userDTO.getRoles());
        user.setWatchlist(userDTO.getWatchlist().stream().map(MovieMapper::toEntity).toList());
        user.setFavourites(userDTO.getFavourites().stream().map(MovieMapper::toEntity).toList());

        return UserMapper.toDto(userRepository.save(user));
    }

    @Override
    public UserDTO deleteUser(Long id) {
        UserDTO returnUser = UserMapper.toDto(userRepository.findById(id).orElse(null));
        userRepository.deleteById(id);
        return returnUser;
    }

    @Override
    public MovieDTO addMovieToWatchlist(UserDTO userDTO, MovieDTO movieDTO) {
        var userOptional = userRepository.findById(userDTO.getId());
        if (userOptional.isEmpty()) {
            return null;
        }

        /*User user = userOptional.get();
        user.getWatchlist().add(MovieMapper.toEntity(movieDTO));
        UserMapper.toDto(userRepository.save(user));
        return movieDTO;*/

        var movieOptional = movieRepository.findById(movieDTO.getId());
        if (movieOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();
        user.getWatchlist().add(movieOptional.get());

        userRepository.save(user);
        return movieDTO;
    }

    @Override
    public MovieDTO addMovieToFavourites(Long userId, Long movieId) {
        var userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            return null;
        }

        var movieOptional = movieRepository.findById(movieId);
        if (movieOptional.isEmpty()) {
            return null;
        }

        User user = userOptional.get();
        user.getFavourites().add(movieOptional.get());

        userRepository.save(user);
        return MovieMapper.toDto(movieRepository.findById(movieId).orElse(null));
    }

    @Override
    public UserDTO findByUsername(String username) {
        return userRepository.findByUsername(username).map(UserMapper::toDto).orElse(null);
    }
    
}
