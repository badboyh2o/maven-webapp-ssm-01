package com.nantian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nantian.dao.UserDao;
import com.nantian.entity.User;
import com.nantian.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;
    
    @Override
    public User findUserByName(String name) {
        return this.userDao.findByUsername(name);
    }
}