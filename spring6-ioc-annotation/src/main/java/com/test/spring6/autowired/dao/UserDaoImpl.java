package com.test.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    public void addUser() {
        System.out.println("Dao: add user");
    }
}
