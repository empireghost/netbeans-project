/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.spring.sample;

import org.springframework.stereotype.Component;

@Component
public class MessageServiceImpl implements  MessageService{

    @Override
    public String getMessage() {
        return "Hello Message";
    }
    
}
