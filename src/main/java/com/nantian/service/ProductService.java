package com.nantian.service;

import com.nantian.entity.Product;

public interface ProductService {
    
    /**
     * 根据id查询
     * @param name
     * @return
     */
    public Product find(String id);
}
