package com.test.spring6.autowired;

import com.test.spring6.autowired.controller.UserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserController {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = (UserController) applicationContext.getBean(UserController.class);
        controller.add();
    }
}
