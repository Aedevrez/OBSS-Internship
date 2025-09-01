package com.example.Day11_FirstSpringProgram.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.Day11_FirstSpringProgram.Calculator;

@Service
public class PrimarySchoolCalcService {
    private final Calculator calculator;

    @Autowired
    public PrimarySchoolCalcService(@Qualifier("SimpleCalculator") Calculator calculator) {
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
}
