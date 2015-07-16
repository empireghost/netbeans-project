/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.rxjava;

import java.util.concurrent.Callable;


public class ExampleCallable implements Callable {

    public Double call() {
        return 3.1415;
    }
}
