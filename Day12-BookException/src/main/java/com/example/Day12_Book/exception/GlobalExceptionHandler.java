package com.example.Day12_Book.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Day12_Book.dto.ErrorResponseDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = BookNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleBookNotFoundException(HttpServletRequest request, BookNotFoundException e) {
        ErrorResponseDTO errorResponseDTO = ErrorResponseDTO.builder().message(e.getMessage()).errorCode(1000L).build();
        return new ResponseEntity<>(errorResponseDTO, HttpStatus.NOT_FOUND);
    }
}
