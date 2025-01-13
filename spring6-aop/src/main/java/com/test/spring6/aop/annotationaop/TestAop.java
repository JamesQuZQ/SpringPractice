package com.test.spring6.aop.annotationaop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    @Test
    public void testAdd(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = (Calculator) applicationContext.getBean(Calculator.class);
        System.out.println("Method return value = " + calculator.add(1,2));
    }

    @Test
    public void testDiv(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = (Calculator) applicationContext.getBean(Calculator.class);
        System.out.println("Method return value = " + calculator.div(1,0));
    }
}
