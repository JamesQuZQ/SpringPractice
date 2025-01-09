package com.test.spring6.autowired.controller;

import com.test.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {


    // Method 1: use @Autowired directly on the attribute
//    @Autowired
//    private UserService userService;

//----------------------------------------------------

    // Method 2: use @Autowired on a set method
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//----------------------------------------------------

    // Method 3: use @Autowired on constructor ** preferred **
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//----------------------------------------------------

    // Method 4: use @Autowired on parameter
//    private UserService userService;
//
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }

//----------------------------------------------------

    // Method 5: no need for @Autowired if there's only one constructor ** preferred **
//    private UserService userService;
//
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//----------------------------------------------------

    // Method 6: @Autowired can be used with @Qualifier when there are multiple instances of the same interface/class
    @Autowired
    @Qualifier("userServiceImpl") // Specify name of bean
    private UserService userService;



    public void add() {
        System.out.println("Controller: add user");
        userService.add();
    }
}
