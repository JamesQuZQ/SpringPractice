package com.test.spring6.iocxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        // Method 1: by ID
//        User user1 = (User) context.getBean("user");
//        System.out.println(user1);

        // Method 2: by class type
        // Note: this does not work when there are multiple instances of the same class
        ClassWithArray array = (ClassWithArray) context.getBean(ClassWithArray.class);
        System.out.println(array);

        // Method 3: by class & type
//        User user3 = (User) context.getBean("user", User.class);
//        System.out.println(user3);

        ClassWithMap map = (ClassWithMap) context.getBean(ClassWithMap.class);
        System.out.println(map);
    }
}
