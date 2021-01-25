package com.nantian.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nantian.dao.ProductDao;
import com.nantian.entity.Product;
import com.nantian.service.ProductService;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductDao productDao;
    
    @Override
    public Product find(String id) {
        return productDao.find(id);
    }
}