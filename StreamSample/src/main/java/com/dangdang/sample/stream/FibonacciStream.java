/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.stream;

import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class FibonacciStream {

    public static void main(String[] args) {
        Stream<Long> fibonacci = Stream.generate(new FibonacciSupplier());
        fibonacci.skip(10).limit(10).forEach(System.out::println);
    }
}
