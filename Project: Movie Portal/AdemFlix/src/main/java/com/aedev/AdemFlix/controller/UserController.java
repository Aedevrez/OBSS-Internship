package com.aedev.AdemFlix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aedev.AdemFlix.dto.MovieDTO;
import com.aedev.AdemFlix.dto.UserDTO;
import com.aedev.AdemFlix.service.IUserService;
import com.aedev.AdemFlix.service.impl.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/users")
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDTO findUserById(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @GetMapping("/{id}/watchlist")
    public List<MovieDTO> fetchWatchlist(@PathVariable Long id) {
        return userService.fetchWatchlistOfUser(userService.findUserById(id));
    }
    
    @GetMapping("/{id}/favourites")
    public List<MovieDTO> fetchFavourites(@PathVariable Long id) {
        return userService.fetchFavouritesOfUser(userService.findUserById(id));
    }

    @PostMapping("/create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PostMapping("/{id}/watchlist/add")
    public MovieDTO addMovieToWatchList(@PathVariable Long id, @RequestBody MovieDTO movieDTO) {
        UserDTO user = userService.findUserById(id);
        return userService.addMovieToWatchlist(user, movieDTO);
    }

    @PostMapping("/{userId}/favourites/add/{movieId}")
    public MovieDTO addMovieToFavourites(@PathVariable Long userId, @PathVariable Long movieId) {
        UserDTO user = userService.findUserById(userId);
        return userService.addMovieToFavourites(userId, movieId);
    }
    

    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return userService.updateUser(id, userDTO);
    }
    
    @DeleteMapping("/{id}")
    public UserDTO deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}
