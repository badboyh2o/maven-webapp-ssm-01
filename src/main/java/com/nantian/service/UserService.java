package com.nantian.service;

import com.nantian.po.Demo;

public interface UserService {
    
    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    public Demo findUserByName(String name);
}
