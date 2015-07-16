/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.springaop;

import org.springframework.aop.framework.ProxyFactory;

public class Main {
    public static void main(String[] args) {
        
        ProxyFactory proxyFactory=new ProxyFactory(); 
        proxyFactory.setExposeProxy(true);
        proxyFactory.addAdvice(new MyBeforeAdvice());
        proxyFactory.setInterfaces(MessageService.class);
        proxyFactory.setTarget(new MessageServiceImpl());
        
        MessageService messageService = (MessageService)proxyFactory.getProxy();
        
        messageService.hello();
        messageService.say();
        
    }
    
}
