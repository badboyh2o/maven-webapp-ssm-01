package com.nantian.service;

import com.nantian.entity.User;

public interface UserService {
    
    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    public User findUserByName(String name);
}
