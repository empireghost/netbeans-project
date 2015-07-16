/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.guava;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
@EqualsAndHashCode
@ToString
public class Person {
    
    private String lastName;
    private Person parent;
    private List<Person> childre;

    public Person(){
    }

    public Person(String lastName, Person parent, List<Person> childre) {
        this.lastName = lastName;
        this.parent = parent;
        this.childre = childre;
    }
    
    
    
    public static void main(String[] args) {
        Person p = new Person();
        p.setLastName("ghost");
        log.debug("person is {}", p);
    }
    
}
