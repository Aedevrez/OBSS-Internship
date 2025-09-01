package com.aedev.AdemFlix.dto;

import java.util.List;
import java.util.Set;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    
    private String username;

    private String password;

    private Set<Role> roles;

    private List<MovieDTO> watchlist;
    
    private List<MovieDTO> favourites;
}
