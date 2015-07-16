/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class Sample {

    private static final Logger logger = LoggerFactory.getLogger(Sample.class);
    
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.parallelStream();
        stream.filter((x) -> {
            return x % 2 == 0;
        }).map((x) -> {
            return x * x;
        }).forEach(new Consumer<Integer>(){
            @Override
            public void accept(Integer t) {
                logger.info("filter and map {}", t);
            }
        });
        
        
        
        Stream<Long> natural = Stream.generate(new NaturalSupplier());
        
        natural.map((x) -> {
            return x * x;
        }).limit(10).parallel().forEach(new Consumer<Long>(){
            @Override
            public void accept(Long t) {
                logger.info("supplier {}", t);
            }
        });
        
    }
}
