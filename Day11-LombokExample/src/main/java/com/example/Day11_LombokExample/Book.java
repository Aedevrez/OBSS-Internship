package com.example.Day11_LombokExample;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
//@Component
public class Book {
    private String title;
    private String author;
    private int pageCount;

    @PostConstruct
    public void init() {
        System.out.println(title + " sisteme girildi");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(title + " sistemden silindi");
    }
}
