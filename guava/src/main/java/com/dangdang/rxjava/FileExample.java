/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.rxjava;

import com.google.common.base.Charsets;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class FileExample {
    
    private static final Logger logger = LoggerFactory.getLogger(FileExample.class);
    
    public static void main(String[] args) {
        try {
            
            File source = new File("c:/source.txt");
            List<String> lines = Files.readLines(source, Charsets.UTF_8);
            //System.out.println(lines.get(0));
            //System.out.println(lines.get(1));
            
            final Pattern p = Pattern.compile("[^0-9a-zA-Z\u4e00-\u9fa5\\[\\],()#.:\\/! -]+");
            
            List<String> results = Lists.transform(lines, new Function<String, String>() {
                @Override
                public String apply(String input) {
                    Matcher m = p.matcher(input);
                    String result = m.replaceAll(" ");
                    return result;
                }
            });
            
            //System.out.println(results.get(0));
            //System.out.println(results.get(1));
            
            File dest = new File("c:/dest.txt");
            
            for (String result : results) {
                Files.append(result, dest, Charsets.UTF_8);
                Files.append("\n", dest, Charsets.UTF_8);
            }
            
            
        } catch (IOException ex) {
            logger.error("", ex);
        }
        
    }
    
}
