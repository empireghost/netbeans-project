/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Administrator
 */
public class JodaTimeExample {

    private static final Logger logger = LoggerFactory.getLogger(JodaTimeExample.class);

    public static void main(String[] args) {

        System.err.println(111 % 2 );
        
        DateTime now = new DateTime();
        logger.info("now is {}",now);
        
        DateTime beginTimeOfToday = now.withTimeAtStartOfDay();
        logger.info("now is {}",beginTimeOfToday);
        
        
        DateTime endTimeOfToday = now.millisOfDay().withMaximumValue();
        logger.info("now is {}",endTimeOfToday);
        
        int hours = Hours.hoursBetween(now, endTimeOfToday).getHours();
        logger.info("to endtime hours is {}",hours);
        
        int days = 5;
        DateTime days5Before = now.withTimeAtStartOfDay()
                .minusDays(days);

        
        logger.info("{} days before zero time is {}",days,days5Before);

    }
}
