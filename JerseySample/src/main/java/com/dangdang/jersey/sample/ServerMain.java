/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.jersey.sample;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Administrator
 */
public class ServerMain {

    public static void main(String[] args) {

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9999).build();
        ResourceConfig config = new ResourceConfig(HelloWorldResource.class,PersonResource.class);
        config.register(JacksonJsonProvider.class);
        
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
        
        
    }
}
