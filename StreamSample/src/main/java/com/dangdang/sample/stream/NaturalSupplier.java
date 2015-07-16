/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.stream;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class NaturalSupplier implements Supplier<Long> {
    
    private final AtomicLong value = new AtomicLong(0);
    
    @Override
    public Long get() {
        return this.value.incrementAndGet();
    }
    
    
    public static void main(String[] args) {
        Stream<Long> stream = Stream.generate(new NaturalSupplier());
        stream.skip(10).limit(1).forEach(System.err::println);
        
    }
}
