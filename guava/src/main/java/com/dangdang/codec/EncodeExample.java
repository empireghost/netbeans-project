/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.codec;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.net.URLCodec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class EncodeExample {
    
    private static final Logger logger = LoggerFactory.getLogger(EncodeExample.class);
    
    public static void main(String[] args) {
        
        try {
            
            String htmlStr =" 管 &amp;<font  class=\"skcolor_ljg\"/>涔</font>、陈祈明联袂推荐）";
            htmlStr = htmlStr.replaceAll("\\<.*?>","");
            logger.info(htmlStr);
            
            String charset = "GBK";
            String targetStr = "忙忙碌碌";
            
            String result = URLEncoder.encode(targetStr, charset);
            logger.info("use URLEncoder GBK result is [{}] ",result);
            
            String s = URLDecoder.decode(result, "gbk");
            logger.info(s);
            
            result = URLEncoder.encode(targetStr, "utf-8");
            logger.info("use URLEncoder UTF-8 result is [{}] ",result);
            
            
            URLCodec codec = new URLCodec("utf-8");
            String str = codec.encode(targetStr);
            logger.info("use ApacheURLCodec result is [{}] ",str);
            
        } catch (Exception ex) {
            logger.error("", ex);
        }
        
    }
    
}
