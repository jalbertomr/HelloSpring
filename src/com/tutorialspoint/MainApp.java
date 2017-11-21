package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Object objA = context.getBean("helloWorld");
        HelloWorld helloWorld = (HelloWorld) objA;
        System.out.println(helloWorld.getMessage());
        System.out.println(helloWorld.getMessage2());

        HelloMexico helloMexico = (HelloMexico) context.getBean("helloMexico");
        System.out.println(helloMexico.getMessage());
        System.out.println(helloMexico.getMessage2());
        System.out.println(helloMexico.getMessage3());
    }
}
