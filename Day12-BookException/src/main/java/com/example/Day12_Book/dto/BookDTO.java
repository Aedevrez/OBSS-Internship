package com.example.Day12_Book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    @NotBlank
    @Size(min=3)
    private String name;

    @NotBlank
    @Size(min=3)
    private String author;
}
