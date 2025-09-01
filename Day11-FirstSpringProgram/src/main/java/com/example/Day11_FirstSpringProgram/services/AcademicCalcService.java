package com.example.Day11_FirstSpringProgram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.Day11_FirstSpringProgram.Calculator;

import jakarta.annotation.PostConstruct;

@Service
public class AcademicCalcService {
    private final Calculator calculator;

    @Autowired
    public AcademicCalcService(@Qualifier("ScientificCalculator") Calculator calculator) {
        this.calculator = calculator;
    }

    public int add(int a, int b) {
        return calculator.add(a, b);
    }

    public int subtract(int a, int b) {
        return calculator.subtract(a, b);
    }

    public int multiply(int a, int b) {
        return calculator.multiply(a, b);
    }

    @PostConstruct
    public void init() {
        System.out.println("Academic Calc created");
    }
}
