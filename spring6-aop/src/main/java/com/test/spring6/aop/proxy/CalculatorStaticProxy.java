package com.test.spring6.aop.proxy;

/**
 * Static proxy for calculator class
 */
public class CalculatorStaticProxy implements Calculator {

    // Declare proxy target as field
    private Calculator target;

    public CalculatorStaticProxy(Calculator target) {
        this.target = target;
    }

    @Override
    public int add(int i, int j) {

        // Implements extra feature of proxy
        System.out.println("[Log] add method starts with parameter:" + i + "," + j);

        // Calls business logic method
        int addResult = target.add(i, j);

        System.out.println("[Log] add ends with result:" + addResult);

        return addResult;
    }

    @Override
    public int sub(int i, int j) {

        System.out.println("[Log] sub method starts with parameter:" + i + "," + j);

        // Calls business logic method
        int subResult = target.sub(i, j);

        System.out.println("[Log] sub ends with result:" + subResult);

        return subResult;
    }

    @Override
    public int mul(int i, int j) {

        System.out.println("[Log] mul method starts with parameter: " + i + "," + j);

        // Calls business logic method
        int mulResult = target.mul(i, j);

        System.out.println("[Log] mul ends with result: " + mulResult);

        return mulResult;
    }

    @Override
    public int div(int i, int j) {

        System.out.println("[Log] div method starts with parameter: " + i + "," + j);

        // Calls business logic method
        int divResult = target.div(i, j);

        System.out.println("[Log] div ends with result: " + divResult);

        return divResult;
    }

}