package com.dangdang.codec;

import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Example {
    
    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    private static String MakeMD5(String input){
        String md5 = new String(DigestUtils.getMd5Digest().digest(input.getBytes(Charset.forName("utf-8"))));
        logger.info("md5 is {}",md5);
        return md5;
    }

    
    private static String base64_encode(String input){
       byte[] result = Base64.encodeBase64(input.getBytes(Charset.forName("utf-8")));
       return new String(result);
    }
    
    private static String base64_decode(String input){
       byte[] result = Base64.decodeBase64(input);
       return new String(result);
    }

    private static byte[] decrypt(byte[] src, String password) {
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom random = new SecureRandom();
            // 创建一个DESKeySpec对象
            DESKeySpec desKey = new DESKeySpec(password.getBytes());
            // 创建一个密匙工厂
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DESede");
            // 将DESKeySpec对象转换成SecretKey对象
            SecretKey securekey = keyFactory.generateSecret(desKey);
            
            // Cipher对象实际完成解密操作
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, securekey, random);
            // 真正开始解密操作
            return cipher.doFinal(src);
        } catch (Exception ex) {
            logger.error("", ex);
        }
        return null;
    }    
    
    public static void main(String[] args) {
        
        
        //dGVzdDAwQGRhbmdkYW5nLmNvbQ== Tl1kKo0C26Y
        String emailCrypt = "dGVzdDAwQGRhbmdkYW5nLmNvbQ==";
        String email = base64_decode(emailCrypt);
        logger.info("email is {}",email);
        
        
        String md5 = MakeMD5(email);
        logger.info("md5 is {}",md5);
        
        
        String keyCrypt = MakeMD5(base64_encode(md5));
        logger.info("keyCrypt is {}",keyCrypt);
        
        byte[] sourceArray = keyCrypt.getBytes(Charset.forName("utf-8"));
        logger.debug("length is "+ sourceArray.length);
        logger.debug("length is "+ Arrays.toString(sourceArray));
        
        int len = 24- sourceArray.length;
        logger.info("to add length is {}",len);
        
        
        byte[] destArray = new byte[24];
//        System.arraycopy(array, 0, newArray, 0, array.length);
//        System.arraycopy(array, 0, newArray, array.length, len);

        System.arraycopy(sourceArray, 0, destArray, 0, sourceArray.length);
        System.arraycopy(sourceArray, 0, destArray, sourceArray.length, len);

        //System.arraycopy(keyBytes, 0, newKeyBytes, 0, keyBytes.length);
        //System.arraycopy(keyBytes, 0, newKeyBytes, keyBytes.length, newKeyBytes.length - keyBytes.length);
        
        logger.debug("newArray is "+ Arrays.toString(destArray));
        logger.debug("newArray length is "+ destArray.length);
        
        String key = new String(destArray,Charset.forName("utf-8"));
        logger.info(key);
        
        String miString = base64_decode("Tl1kKo0C26Y");
        String result = new String(decrypt(miString.getBytes(Charset.forName("utf-8")), key));
        logger.info("result is {}",result);
        
    }
    
}
