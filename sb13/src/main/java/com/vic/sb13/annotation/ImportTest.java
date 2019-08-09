package com.vic.sb13.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Import注解使用
 * https://segmentfault.com/a/1190000011068471
 * @author 罗利华
 * date: 2019/7/25 17:24
 */
public class ImportTest {
    public static void main (String args[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ParentConfig.class);
        Car car = (Toyota)context.getBean("toyota");
        car.print();
        car = (Volkswagen)context.getBean("volkswagen");
        car.print();
        context.close();
    }
}
