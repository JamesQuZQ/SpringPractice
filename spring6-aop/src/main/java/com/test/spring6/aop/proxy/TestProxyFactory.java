package com.test.spring6.aop.proxy;

import org.junit.Test;

public class TestProxyFactory {

    @Test
    public void testDynamicProxy(){
        ProxyFactory factory = new ProxyFactory(new CalculatorImpl());
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.div(1,1);
    }
}
