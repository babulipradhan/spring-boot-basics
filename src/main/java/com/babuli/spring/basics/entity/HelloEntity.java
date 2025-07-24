package com.babuli.spring.basics.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name = "hello")
public class HelloEntity {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    @Override
    public String toString() {
        return name;
    }
}
