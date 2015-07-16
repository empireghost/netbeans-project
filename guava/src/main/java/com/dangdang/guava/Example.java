package com.dangdang.guava;

import com.google.common.primitives.Longs;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2014/11/11.
 */
public class Example {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    private String name;
    
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    
    
    
    public static void main(String[] args) {
        
        Longs.compare(2L, 4L);
        
        logger.info("this is a test");
        logger.error("error :{}", new RuntimeException("ghost"));

        
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<String> explosion = service.submit(new Callable<String>() {
            @Override
            public String call() {
                int i = 2;
                if (i % 2 == 1){
                   throw new RuntimeException("error throw");
                }
                return "ghost";
            }
        });
        
        
        Futures.addCallback(explosion, new FutureCallback<String>() {
            // we want this handler to run immediately after we push the big red button!
            
            @Override
            public void onSuccess(String result) {
                logger.info("result is {}",result);
            }

            @Override
            public void onFailure(Throwable thrown) {
                logger.error("error:", thrown);
            }
        });
        
        service.shutdown();
    }
}
