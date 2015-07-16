/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.rxjava;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.functions.Action1;

/**
 *
 * @author Administrator
 */
public class Test {

    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    
    public static void main(String[] args) {
        
        String str = "中国，山东省，青岛市，城阳区，三利大厦，100000";
        //String str = "中国，北京，北京市，东城区，三利大厦，100000";
        CharMatcher charMatcher = CharMatcher.anyOf("，。‘");
        String result = charMatcher.replaceFrom(str, " ");
        logger.info("result is {}",result);
        
        String[] strs = result.split(" ");
        logger.info("strs is {}" , Arrays.toString(strs));
        strs[0] = null;
        String[] zxs = {"北京","上海","天津","重庆"};
                
        if (Arrays.asList(zxs).contains(strs[1])){
            strs[1] = null;
        }
        
        
        String address = Joiner.on(" ").skipNulls().join(strs);
        logger.info("address is {}", address);
        
        
        
        String[] names = str.split("，");        
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                logger.info("Hello " + s + "!");
            }
        });
    }
}
