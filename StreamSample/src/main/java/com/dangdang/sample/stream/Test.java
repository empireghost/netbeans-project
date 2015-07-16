/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.stream;

import org.apache.commons.lang.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class Test {
    
    private static  final Logger logger = LoggerFactory.getLogger(Test.class);
    
    public static void main(String[] args) {
        String source = "&lt;itemRule&gt;&lt;field id=&quot;prop_1636953&quot; name=&quot;ISBN编号&quot; type=&quot;input&quot;&gt;&lt;rules&gt;&lt;rule name=&quot;requiredRule&quot; value=&quot;true&quot;/&gt;&lt;/rules&gt;&lt;/field&gt;&lt;/itemRule&gt;";
        String result = StringEscapeUtils.unescapeXml(source);
        logger.info(result);
    }
    
}
