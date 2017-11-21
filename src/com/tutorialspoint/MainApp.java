package com.tutorialspoint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) {
        //AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        //Object objA = context.getBean("helloWorld");
        //HelloWorld helloWorld = (HelloWorld) objA;
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        System.out.println(helloWorld.getMessage());

        context.registerShutdownHook();
    }
}
