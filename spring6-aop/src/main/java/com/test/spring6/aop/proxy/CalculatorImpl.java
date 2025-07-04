package com.test.spring6.aop.proxy;

public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {

        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    @Override
    public int mul(int i, int j) {
        return i * j;
    }

    @Override
    public int div(int i, int j) {
        // Assumes j not 0
        return i / j;
    }
}
