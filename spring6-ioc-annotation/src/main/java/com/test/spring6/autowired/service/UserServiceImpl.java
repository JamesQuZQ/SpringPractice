package com.test.spring6.autowired.service;

import com.test.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("Service: add user");
        userDao.addUser();
    }
}
