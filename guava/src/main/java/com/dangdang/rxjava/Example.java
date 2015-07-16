/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.rxjava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    public static void main(String[] args) {

//        try {
//            //加载MySql的驱动类   
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            String url = "jdbc:oracle:thin:@10.255.255.17:1521:erptest2";
//            String username = "wmserpyw";
//            String password = "wmserpyw";
//            Connection con = DriverManager.getConnection(url, username, password);
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("select * from JKXX_YJCGL_API_TO_ERP");
//            while (rs.next()){
//                System.out.println(rs.getString(1));
//            }
//            
//        } catch (Exception e) {            
//            e.printStackTrace();
//        }
        //Pattern p = Pattern.compile("[\u4e00-\u9fa5]+");
        Pattern p = Pattern.compile("[^0-9a-zA-Z\u4e00-\u9fa5\\[\\],()#.:\\/! ]+");
        //Pattern p = Pattern.compile("[，。‘’]");
        String s = "文‘’件b，c。d‘e'f１２３４问54356454나의,()#.:\\/! iPhone에서 보냄.，,。？“”‘’";
        //String s = "中文件b，c。d‘e'f１２３４问54356454";
        //String s = "中国，北京，北京市，东城区，三利大厦，100000";
        Matcher m = p.matcher(s);
        String result = m.replaceAll(" ");
        logger.info("result is [{}]", result);

    }
}
