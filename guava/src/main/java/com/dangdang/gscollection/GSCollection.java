/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.gscollection;

import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.list.mutable.MultiReaderFastList;

/**
 *
 * @author Administrator
 */
public class GSCollection {

    public static void main(String[] args) {
        
        MutableList<String> customers = new MultiReaderFastList<String>();
        customers.add("A");
        
        
    }
}
