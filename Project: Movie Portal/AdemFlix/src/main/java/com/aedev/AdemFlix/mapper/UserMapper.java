package com.aedev.AdemFlix.mapper;

import com.aedev.AdemFlix.dto.UserDTO;
import com.aedev.AdemFlix.entity.User;

public class UserMapper {
    public static UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }

        return UserDTO.builder()
                       .id(user.getId())
                       .username(user.getUsername())
                       .password(user.getPassword())
                       .roles(user.getRoles())
                       .favourites(user.getFavourites().stream().map(MovieMapper::toDto).toList())
                       .watchlist(user.getWatchlist().stream().map(MovieMapper::toDto).toList())
                       .build();
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        return User.builder()
                   .id(userDTO.getId())
                   .username(userDTO.getUsername())
                   .password(userDTO.getPassword())
                   .roles(userDTO.getRoles())
                   .favourites(userDTO.getFavourites().stream().map(MovieMapper::toEntity).toList())
                   .watchlist(userDTO.getWatchlist().stream().map(MovieMapper::toEntity).toList())
                   .build();
    }
}
