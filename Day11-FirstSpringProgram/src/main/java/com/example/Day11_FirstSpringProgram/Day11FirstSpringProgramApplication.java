package com.example.Day11_FirstSpringProgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.Day11_FirstSpringProgram.services.AcademicCalcService;
import com.example.Day11_FirstSpringProgram.services.PrimarySchoolCalcService;

@SpringBootApplication
public class Day11FirstSpringProgramApplication {

	public static void main(String[] args) {
		//SpringApplication.run(Day11FirstSpringProgramApplication.class, args);
		ConfigurableApplicationContext context = SpringApplication.run(Day11FirstSpringProgramApplication.class, args);

		PrimarySchoolCalcService primarySchoolCalcService = context.getBean(PrimarySchoolCalcService.class);
		AcademicCalcService academicCalcService = context.getBean(AcademicCalcService.class);

		System.out.println("Primary School Calculator 3 + 5 = " + primarySchoolCalcService.add(3, 5));
		System.out.println("Academic Calculator 3 - 5 = " + academicCalcService.subtract(3, 5));
		System.out.println("Primary School Calculator 3 * 5 = " + primarySchoolCalcService.multiply(3, 5));
	}

}
