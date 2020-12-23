package com.nantian.dao;

import com.nantian.entity.Demo;

public interface UserDao {
    
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public Demo findByUsername(String username);
}
