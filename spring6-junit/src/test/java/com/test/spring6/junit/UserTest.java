package com.test.spring6.junit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.*;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class UserTest {

    @Autowired
    private User user;

    @Test
    public void testUser(){
        System.out.println(user);
        user.run();
    }

}
