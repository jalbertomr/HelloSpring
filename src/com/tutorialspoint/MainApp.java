package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        Object objA = context.getBean("helloWorld");
        HelloWorld helloWorld = (HelloWorld) objA;
        System.out.println(helloWorld.getMessage());

        context.registerShutdownHook();
    }
}
