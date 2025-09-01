package com.example.Day12_Book.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {
    private String message;
    private Long errorCode;
}
