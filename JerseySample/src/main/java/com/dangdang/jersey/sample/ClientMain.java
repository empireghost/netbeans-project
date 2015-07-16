/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.jersey.sample;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        Response response = client.target("http://localhost:9999/").path("helloworld").request().get();
        logger.info("status is {}",response.getStatus());
        logger.info(response.readEntity(String.class));

        String xml = client.target("http://localhost:9999/").path("person").request(MediaType.APPLICATION_XML).get(String.class);
        logger.info("xml result is {}",xml);

        String json = client.target("http://localhost:9999/").path("person").request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
        logger.info("json result is {}",json);
    }
}
