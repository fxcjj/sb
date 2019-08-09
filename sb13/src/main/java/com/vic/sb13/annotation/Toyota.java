package com.vic.sb13.annotation;

import org.springframework.stereotype.Component;

//@Component 不用标记，在JavaConfigA中已经声明了一个Toyota实例
public class Toyota implements Car{
    public void print(){
        System.out.println("I am Toyota");
    }
}