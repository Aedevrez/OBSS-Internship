package com.example.Day12_Book.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Day12_Book.dto.BookDTO;
import com.example.Day12_Book.model.Book;

@Service
public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    BookDTO createBook(BookDTO bookDTO);
    BookDTO updateBookById(Long id, BookDTO bookDTO);
    BookDTO deleteBookById(Long id);
}
