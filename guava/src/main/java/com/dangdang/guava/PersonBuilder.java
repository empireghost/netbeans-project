/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dangdang.guava;

import java.util.List;


public class PersonBuilder {
    private String lastName;
    private Person parent;
    private List<Person> childre;

    public PersonBuilder() {
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setParent(Person parent) {
        this.parent = parent;
        return this;
    }

    public PersonBuilder setChildre(List<Person> childre) {
        this.childre = childre;
        return this;
    }

    public Person createPerson() {
        return new Person(lastName, parent, childre);
    }
    
}
