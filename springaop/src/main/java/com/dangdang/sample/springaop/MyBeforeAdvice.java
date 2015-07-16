/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.springaop;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

/**
 *
 * @author Administrator
 */
public class MyBeforeAdvice implements MethodBeforeAdvice {
    
    private static final Logger logger = LoggerFactory.getLogger(MyBeforeAdvice.class);

    @Override
    public void before(Method method, Object[] os, Object o) throws Throwable {
        logger.debug("target is {}",o);
        logger.info("before");
    }
    
}
