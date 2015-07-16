package com.dangdang.guava;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunPHPExample {

    private static final Logger logger = LoggerFactory.getLogger(RunPHPExample.class);

    public static final String KEY_ALGORITHM = "DES";

    public static final String CIPHER_ALGORITHM = "DES/ECB/PKCS5Padding";

    public static byte[] initkey() throws Exception {

        //实例化密钥生成器  
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        //初始化密钥生成器  
        kg.init(56);
        //生成密钥  
        SecretKey secretKey = kg.generateKey();
        //获取二进制密钥编码形式  
        return secretKey.getEncoded();
    }

    public static Key toKey(byte[] key) throws Exception {
        //实例化Des密钥  
        DESKeySpec dks = new DESKeySpec(key);
        //实例化密钥工厂  
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        //生成密钥  
        SecretKey secretKey = keyFactory.generateSecret(dks);
        return secretKey;
    }


    public static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        //还原密钥  
        Key k = toKey(key);
        //实例化  
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为加密模式  
        cipher.init(Cipher.ENCRYPT_MODE, k);
        //执行操作  
        return cipher.doFinal(data);
    }


    public static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        //欢迎密钥  
        Key k = toKey(key);
        //实例化  
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为解密模式  
        cipher.init(Cipher.DECRYPT_MODE, k);
        //执行操作  
        return cipher.doFinal(data);
    }


    public static void main(String[] args) throws Exception {
        //String commandStr = "php CryptoHelper.php dGVzdDAwQGRhbmdkYW5nLmNvbQ== Tl1kKo0C26Y=";
        String str = "2";
        System.out.println("原文：" + str);
        String keyStr = "dGVzdDAwQGRhbmdkYW5nLmNvbQ==";
        System.out.println(new String(Base64.decodeBase64(keyStr)));
        //初始化密钥  
        byte[] key = "test00@dangdang.com".getBytes();
        System.out.println("密钥：" + Base64.encodeBase64String(key));
        //加密数据  
        byte[] data = RunPHPExample.encrypt(str.getBytes(), key);
        System.out.println("加密后：" + Base64.encodeBase64String(data));
        //解密数据  
        data = RunPHPExample.decrypt(data, key);
        System.out.println("解密后：" + new String(data));
    }
}
