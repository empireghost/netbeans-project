/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.codec;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MD5Util {
	
	private static final Logger log = LoggerFactory.getLogger(MD5Util.class);
	public static final String CHARSET_UTF8="utf-8";
	public static final String CHARSET_GBK="utf-8";


	public static String md5(String source, String charset) {
		if (charset == null || charset.isEmpty()) {
			charset = CHARSET_UTF8;
		}
		
		StringBuilder sb = new StringBuilder();
		try {
            byte[] digest = md5(source.getBytes(charset));
			String tmp;
			for (byte b : digest) {
				tmp = Integer.toHexString(b & 0XFF);
				if (tmp.length() == 1) {
					sb.append("0");
					sb.append(tmp);
				} else {
					sb.append(tmp);
				}
			}
		} catch (UnsupportedEncodingException e) {
			log.error("UnsupportedEncodingException e is {} ",e);
		}
		return sb.toString();
	}


    public static byte[] md5(byte[] bytes) {
		byte[] result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(bytes);
			result = md.digest();
		} catch (NoSuchAlgorithmException e) {
			log.error("NoSuchAlgorithmException {} ",e);
			throw new RuntimeException(e);
		}
		return result;
	}
}
