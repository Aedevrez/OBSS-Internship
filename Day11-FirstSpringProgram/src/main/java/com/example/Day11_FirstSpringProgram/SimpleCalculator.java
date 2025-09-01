package com.example.Day11_FirstSpringProgram;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service(value="SimpleCalculator")
public class SimpleCalculator implements Calculator{

    @Override
    public int add(int a, int b) {
        System.out.println("Simple add");
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        System.out.println("Simple subtract");
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        System.out.println("Simple multiply");
        return a*b;
    }

    @PostConstruct
    public void init() {
        System.out.println("Created");
    }
}
