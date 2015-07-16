/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.guava;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class FunctionExample {

    private static final Logger logger = LoggerFactory.getLogger(FunctionExample.class);
    
//    static void modifyTheValue(int valueToBeOperated, Function<Integer, Integer> function) {
//        int newValue = function.apply(valueToBeOperated);
//        System.out.println(newValue);
//    }

    public static void main(String[] args) {

        String s = "product_%s_%s.xml";
        Formatter ft = new Formatter();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
        
        ft.format(s, sdf.format(new Date()), 2);
        
        System.err.println(ft.toString());
        
        System.err.println((double)4/5);
        
        int incr = 20;
        int myNumber = 10;

//        modifyTheValue(myNumber, val -> val + incr);
//        myNumber = 15;
//        modifyTheValue(myNumber, val -> val * 10);
//        modifyTheValue(myNumber, val -> val - 100);
//        modifyTheValue(myNumber, val -> "somestring".length() + val - 100);
//        
    }
}
