/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.resteasy;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import org.jboss.resteasy.plugins.server.sun.http.HttpContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class ServerMain {

    private static final Logger logger = LoggerFactory.getLogger(ServerMain.class);
    
    public static void main(String[] args) {
        try {
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(9999), 10);
            HttpContextBuilder contextBuilder = new HttpContextBuilder();
            contextBuilder.getDeployment().getActualResourceClasses().add(PersonResource.class);
            contextBuilder.getDeployment().getActualResourceClasses().add(HelloWorldResource.class);
            
            HttpContext context = contextBuilder.bind(httpServer);
            httpServer.start();
        } catch (IOException ex) {
            logger.error("", ex);
        }

    }
}
