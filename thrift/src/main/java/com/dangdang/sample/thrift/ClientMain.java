package com.dangdang.sample.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientMain {

    private static final Logger logger = LoggerFactory.getLogger(ClientMain.class);

    public static void main(String[] args) {

        try {
            TTransport transport = new TSocket("localhost", 9090);
            
            StopWatch stopWatch = new Slf4JStopWatch();
            stopWatch.start("run 1000 times");
            transport.open();
            for (int i = 0; i < 10000; i++) {
                TProtocol protocol = new TBinaryProtocol(transport);
                Calculator.Client client = new Calculator.Client(protocol);
                logger.info("result is {}", client.add(1, 2));
                client.ping();
            }
            stopWatch.stop("run 1000 times");
            transport.close();
        } catch (TException ex) {
            logger.error("", ex);
        }

    }
}
