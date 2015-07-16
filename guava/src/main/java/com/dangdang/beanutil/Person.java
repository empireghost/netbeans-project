/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.beanutil;

import com.dangdang.guava.Example;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class Person {
    
    private static final Logger logger = LoggerFactory.getLogger(Example.class);
    
    private String name;
    private List<String> borthers;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBorthers() {
        return borthers;
    }

    public void setBorthers(List<String> borthers) {
        this.borthers = borthers;
    }
    
    
    public static void main(String[] args) {
        try {
            Person p = new Person();
            List<String> brothers = new ArrayList<String>();
            brothers.add("a");
            brothers.add("b");
            brothers.add("c");
            
            BeanUtils.setProperty(p, "borthers", brothers);
            String[] strs = BeanUtils.getArrayProperty(p, "borthers");
            
            logger.info("{}", Arrays.toString(strs));
            logger.info("result is {} {}", strs);
            
        } catch (IllegalAccessException ex) {
            logger.error("", ex);
        } catch (InvocationTargetException ex) {
            logger.error("", ex);
        } catch (NoSuchMethodException ex) {
            logger.error("", ex);
        }
    }
    
}
