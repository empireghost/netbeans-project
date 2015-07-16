/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class Provider {
    
    private static final Logger logger = LoggerFactory.getLogger(Provider.class);
 
    public static void main(String[] args) throws Exception {
        logger.info("begin");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"dubbo-provider.xml"});
        context.start();
 
        System.in.read(); // 按任意键退出
    }
 
}
