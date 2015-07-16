/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.server.embed.jetty;

import org.eclipse.jetty.server.Server;

/**
 *
 * @author Administrator
 */
public class JettyServerSample {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        server.setHandler(new HelloHandler());
        server.start();
        server.dumpStdErr();
        server.join();
    }
}
