package com.test.spring6.aop.xmlaop;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {
        System.out.println("Inside add method");
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("Inside sub method");
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("Inside mul method");
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("Inside div method");
        // Assumes j not 0
        try {
            return i / j;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
