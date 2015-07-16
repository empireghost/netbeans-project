/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.sample.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author Administrator
 */
public class PiSupplier implements Supplier<Double> {

    double sum = 0.0;
    double current = 1.0;
    boolean sign = true;

    @Override
    public Double get() {
        sum += (sign ? 4 : -4) / this.current;
        this.current = this.current + 2.0;
        this.sign = !this.sign;
        return sum;
    }

    public static void main(String[] args) {
        Stream<Double> piStream = Stream.generate(new PiSupplier());
        piStream.skip(10000000).limit(10).forEach(System.out::println);
    }
}
