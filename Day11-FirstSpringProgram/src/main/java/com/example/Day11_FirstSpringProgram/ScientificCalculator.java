package com.example.Day11_FirstSpringProgram;

import org.springframework.stereotype.Service;

@Service(value="ScientificCalculator")
public class ScientificCalculator implements Calculator {

    @Override
    public int add(int a, int b) {
        System.out.println("Scientific add");
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("Scientific subtract");
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        System.out.println("Scientific multiply");
        return a*b;
    }
}
