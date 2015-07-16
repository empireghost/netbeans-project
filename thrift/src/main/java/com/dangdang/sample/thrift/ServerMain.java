/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.thrift;

import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TServerTransport;
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
            CalculatorHandler handler = new CalculatorHandler();
            Calculator.Processor processor = new Calculator.Processor(handler);
            TServerTransport serverTransport = new TServerSocket(9090);
            //TServer server = new TSimpleServer(new Args(serverTransport).processor(processor));
            // Use this for a multithreaded server
            TServer server = new TThreadPoolServer(new TThreadPoolServer.Args(serverTransport).processor(processor));
            logger.info("Starting the simple server...");
            server.serve();
            
        } catch (Exception e) {
            logger.error("", e);
        }
    }

}
