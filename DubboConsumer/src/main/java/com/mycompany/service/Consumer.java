/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);
    
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService"); // 获取远程服务代理  
        String hello = demoService.sayHello("world"); // 执行远程方法  
        logger.info(hello);
        System.in.read(); // 按任意键退出
        String str = demoService.sayHello("hello"); // 执行远程方法  
        logger.info(str);
        
    }
}
