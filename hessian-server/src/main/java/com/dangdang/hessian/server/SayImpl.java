/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.hessian.server;


public class SayImpl implements ISay{

    public String sayHello(String arg) {
        return "hello " + arg;
    }

    public Person hello() {
        return new Person(123);
    }
    
}
