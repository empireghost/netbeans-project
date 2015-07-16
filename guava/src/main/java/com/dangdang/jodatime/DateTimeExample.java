package com.dangdang.jodatime;


import org.joda.time.DateTime;

/**
 *
 * @author Administrator
 */
public class DateTimeExample {

    public static void main(String[] args) {
        DateTime now = DateTime.now();
        
        DateTime first = now.withTimeAtStartOfDay();
        
        System.out.println(first);
        
    }
    
}
