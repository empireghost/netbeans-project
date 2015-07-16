/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;

/**
 *
 * @author Administrator
 */
public class MessageServiceImpl implements MessageService{

    private static final Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);
    
    @Override
    public void say() {
        logger.error("say");
    }

    @Override
    public void hello() {
        logger.error("hello");
        say();
    }
    
}
