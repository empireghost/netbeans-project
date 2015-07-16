/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.thread;

/**
 *
 * @author Administrator
 */
public class Task implements Runnable {

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        System.out.println(Integer.parseInt("123"));
        System.out.println(Integer.parseInt("234"));
        System.out.println(Integer.parseInt("345"));
        System.out.println(Integer.parseInt("XYZ")); //This will cause NumberFormatException
        System.out.println(Integer.parseInt("456"));
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been capturedn");
        System.out.printf("Thread: %sn", t.getId());
        System.out.printf("Exception: %s: %sn", e.getClass().getName(), e.getMessage());
        System.out.printf("Stack Trace: n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %sn", t.getState());
        new Thread(new Task()).start();
    }
}
