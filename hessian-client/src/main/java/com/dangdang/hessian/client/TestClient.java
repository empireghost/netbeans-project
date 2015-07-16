/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.hessian.client;

import com.dangdang.hessian.server.ISay;
import com.dangdang.hessian.server.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Administrator
 */
public class TestClient {

    public static void main(String[] args) {
        try {
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            ISay hello = (ISay) context.getBean("helloServiceClient");
            
            System.out.println(hello.sayHello("Spring Hession"));
            
            Person p = hello.hello();
            
            System.err.println(p.getId());
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
