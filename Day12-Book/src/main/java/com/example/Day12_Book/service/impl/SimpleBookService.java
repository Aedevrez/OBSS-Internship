package com.example.Day12_Book.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Day12_Book.dto.BookDTO;
import com.example.Day12_Book.model.Book;
import com.example.Day12_Book.service.BookService;

@Service
public class SimpleBookService implements BookService {
    List<Book> books;

    public SimpleBookService() {
        this.books = new ArrayList<>();

        Book book1 = Book.builder()
            .id(1L)
            .name("The Final Empire")
            .author("Brandon Sanderson")
            .build();
        
        Book book2 = Book.builder()
            .id(2L)
            .name("Eye of the World")
            .author("Robert Jordan")
            .build();

        books.add(book1);
        books.add(book2);
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(Long id) {
        return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book createdBook = Book.builder()
            .id((long) (books.size() + 1))
            .name(bookDTO.getName())
            .author(bookDTO.getAuthor())
            .build();
        books.add(createdBook);
        return createdBook.toBookDTO();
    }

    @Override
    public BookDTO updateBookById(Long id, BookDTO bookDTO) {
        Book updatedBook = findById(id);
        updatedBook.setName(bookDTO.getName());
        updatedBook.setAuthor(bookDTO.getAuthor());
        return updatedBook.toBookDTO();
    }

    @Override
    public BookDTO deleteBookById(Long id) {
        Book deletedBook = findById(id);
        books.remove(deletedBook);
        return deletedBook.toBookDTO();
    }
}
