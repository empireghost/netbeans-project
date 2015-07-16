/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.resteasy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class ClientMain {

    private static final Logger logger = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) {
        Client client = ClientBuilder.newBuilder().build();
//        WebTarget target = client.target("http://localhost:9999/helloworld");
//        Response response = target.request().get();
//        String value = response.readEntity(String.class);
//        logger.info("status is {}",response.getStatus());
//        logger.info("value is {}",value);
//        response.close(); 
//
//        String xml = client.target("http://localhost:9999/").path("person").request(MediaType.APPLICATION_XML).get(String.class);
//        logger.info("xml result is {}",xml);
//
//        String json = client.target("http://localhost:9999/").path("person").request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
//        logger.info("json result is {}",json);
        
        
        Response image = client.target("http://localhost:9999/").path("person").path("download").request().get();
        InputStream is = image.readEntity(InputStream.class);
        
        try {
            FileOutputStream os = new FileOutputStream("bai.png");
            IOUtils.copy(is, os);
        } catch (Exception ex) {
            logger.error("", ex);
        }
        
        
        
    }
}
