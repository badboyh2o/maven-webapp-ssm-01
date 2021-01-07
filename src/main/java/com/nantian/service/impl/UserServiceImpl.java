package com.nantian.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nantian.po.Demo;
import com.nantian.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Override
    public Demo findUserByName(String name) {
        return null;
    }
}