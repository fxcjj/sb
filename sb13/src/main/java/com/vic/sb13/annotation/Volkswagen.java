package com.vic.sb13.annotation;

import org.springframework.stereotype.Component;

//@Component
public class Volkswagen implements Car{
    public void print(){
        System.out.println("I am Volkswagen");
    }
}