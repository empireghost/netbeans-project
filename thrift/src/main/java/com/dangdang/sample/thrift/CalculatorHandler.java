/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.thrift;

import org.apache.thrift.TException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class CalculatorHandler implements Calculator.Iface{
    
    private static final Logger logger = LoggerFactory.getLogger(CalculatorHandler.class);
    
    @Override
    public void ping() throws TException {
        logger.info("pong");
    }

    @Override
    public int add(int num1, int num2) throws TException {
        logger.info("add");
        return num1+num2;
    }
    
}
