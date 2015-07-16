package com.dangdang.jersey.sample;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.net.URI;
import javax.ws.rs.core.UriBuilder;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class JettyServerMain {

    public static void main(String[] args) {
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9999).build();
        ResourceConfig config = new ResourceConfig(HelloWorldResource.class,PersonResource.class);
        config.register(JacksonJsonProvider.class);
        
        
        Server server = JettyHttpContainerFactory.createServer(baseUri, config);
        
    }

}
