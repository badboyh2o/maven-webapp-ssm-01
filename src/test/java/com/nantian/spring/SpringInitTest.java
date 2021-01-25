package com.nantian.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nantian.service.UserService;
import com.nantian.service.impl.UserServiceImpl;

@Configurable
public class SpringInitTest {

    public static void main(String[] args) {
        
        
        ClassPathXmlApplicationContext ac1 = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService bean1 = ac1.getBean(UserService.class);
        System.out.println(bean1);
        
        
        
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringInitTest.class);
        UserService bean = ac.getBean(UserServiceImpl.class);
        System.out.println(bean == null);
        
        
        
    }
    
    
}
