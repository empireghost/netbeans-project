/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.server.embed.tomcat;

import java.io.File;
import org.apache.catalina.startup.Tomcat;

/**
 *
 * @author Administrator
 */
public class TomcatServerSample {

    public static void main(String[] args) {
        try {
            Tomcat tomcat = new Tomcat();
            tomcat.setPort(8080);
            
            
            String webappDirLocation = "D:\\apache-tomcat-8.0.23\\webapps\\ROOT";
            tomcat.addWebapp("/abc", new File(webappDirLocation).getAbsolutePath());
            System.out.println("configuring app with basedir: " + new File(webappDirLocation).getAbsolutePath());

            tomcat.start();
            tomcat.getServer().await();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
