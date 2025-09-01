package com.example.Day12_Book.model;

import com.example.Day12_Book.dto.BookDTO;

//import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {
    private Long id;
    private String name;
    private String author;
    //private Date date;

    public BookDTO toBookDTO() {
        BookDTO newBookDTO = BookDTO.builder()
                                .name(name)
                                .author(author)
                                .build();
        return newBookDTO;
    }
}
