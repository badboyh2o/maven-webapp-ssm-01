package com.nantian.service;

import com.nantian.entity.Demo;

public interface UserService {
    
    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    public Demo findUserByName(String name);
}
