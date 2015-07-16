
package com.dangdang.hessian.client;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Example {
    public static void main(String[] args) {
        
        Long begin = 1435046403320L;
        Long end = 1435050000025L;
        
        Long thirtyMinutes = 30*60*1000L;
        Date beginDate = new Date(begin-thirtyMinutes);
        Date endDate = new Date(end);
        
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        
        System.err.println(df.format(beginDate));
        System.err.println(df.format(endDate));
    }
}
