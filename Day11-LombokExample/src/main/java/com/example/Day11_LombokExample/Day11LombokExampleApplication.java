package com.example.Day11_LombokExample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day11LombokExampleApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Day11LombokExampleApplication.class, args);
		Book mb1 = new Book("The Final Empire", "Brandon Sanderson", 500);
		System.out.println(mb1);
		mb1.setTitle("The Final Empire - A Mistborn Novel");
		mb1.setAuthor("B. Sanderson");
		System.out.println(mb1);

	}

}
