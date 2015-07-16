/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SubListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        int chunkSize = 2;
        
        if (list == null){
            return;
        }
        if (list.size() <= chunkSize){
            System.out.println(list);
        }
        
        int times = (0 == list.size() % chunkSize) ? list.size() / chunkSize : list.size() / chunkSize + 1;
        System.out.println(times);
        
        for (int i = 0; i < times; i++) {
            int toIndex = (i + 1) * chunkSize;
            if (toIndex > list.size()){
                toIndex = list.size();
            }    
            List<String> subIdList = list.subList(i * chunkSize, toIndex);
            System.err.println(subIdList);
        }
        
        
    }
}
