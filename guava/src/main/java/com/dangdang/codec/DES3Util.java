package com.dangdang.codec;


import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;

public class DES3Util {

    private final static String CHARSET = "UTF-8";

    public static void main(String[] args) throws Exception {
        //test00@dangdang.com=2
        //dGVzdDAwQGRhbmdkYW5nLmNvbQ== Tl1kKo0C26Y=
        
        //liuhahaya@163.com=2
        //custIdCrypt=6P0GNxVEZrTen1LFGt7syg==
        //email=bGl1aGFoYXlhQDE2My5jb20=   
        //vipType=OExRG4mCKtY=
        String vipType = "2";
        String emailCrypt = "bGl1aGFoYXlhQDE2My5jb20=";
        byte[] result = Base64.decodeBase64(emailCrypt);
        String email = new String(result);
        System.err.println("email is " + email);
        
        String encryVipType = "OExRG4mCKtY=";

        System.err.println("vipType encrypt is "+encrypt(vipType, email));
        System.err.println("vipType decrypt is "+decrypt(encryVipType, email));

        
        String custId = "46706613"; 
        String custIdCrypt = "6P0GNxVEZrTen1LFGt7syg==";
        //cookie_crypto_key_initial
        String key = "cookie_crypto_key_initial"+email;
        
        System.out.println("custId encrypt is "+encrypt(custId, key));
        System.out.println("custId decrypt is "+decrypt(custIdCrypt, key));
        
    }


    public static String encrypt(String original, String key) throws Exception {
        return encode(encryptECB(original.getBytes(CHARSET), getKeyBytes(key)));
    }

    public static String decrypt(String encrypted, String key) throws Exception {
        return new String(decryptECB(decode(encrypted), getKeyBytes(key)), CHARSET);
    }


    private static byte[] getKeyBytes(String key) throws UnsupportedEncodingException {
        String keyHash = key = encode(MD5Util.md5(key.getBytes(CHARSET)));
        byte[] keyBytes = MD5Util.md5(keyHash.getBytes(CHARSET));
        byte[] newKeyBytes = new byte[24];
        System.arraycopy(keyBytes, 0, newKeyBytes, 0, keyBytes.length);
        System.arraycopy(keyBytes, 0, newKeyBytes, keyBytes.length, newKeyBytes.length - keyBytes.length);
        return newKeyBytes;
    }


    public static String encode(byte[] binaryData) throws UnsupportedEncodingException {
        return new String(Base64.encodeBase64(binaryData), CHARSET);
    }


    public static byte[] decode(String base64String) throws UnsupportedEncodingException {
        return Base64.decodeBase64(base64String.getBytes(CHARSET));
    }


    public static byte[] encryptECB(byte[] data, byte[] key) throws Exception {
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        Key deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, deskey);
        return cipher.doFinal(data);
    }


    public static byte[] decryptECB(byte[] data, byte[] key) throws Exception {
        DESedeKeySpec spec = new DESedeKeySpec(key);
        SecretKeyFactory keyfactory = SecretKeyFactory.getInstance("DESede");
        Key deskey = keyfactory.generateSecret(spec);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        return cipher.doFinal(data);
    }

}
