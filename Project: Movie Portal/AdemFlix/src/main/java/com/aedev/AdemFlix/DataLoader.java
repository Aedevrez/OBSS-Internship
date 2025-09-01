package com.aedev.AdemFlix;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.aedev.AdemFlix.entity.Role;
import com.aedev.AdemFlix.entity.User;
import com.aedev.AdemFlix.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (userRepository.count() == 0) {
            userRepository.save(User.builder()
                .username("admin")
                .password(passwordEncoder.encode("adminpass"))
                .roles(Set.of(Role.ADMIN, Role.USER))
                .build());
            userRepository.save(User.builder()
                .username("user")
                .password(passwordEncoder.encode("userpass"))
                .roles(Set.of(Role.USER))
                .build());
        }
    }
}