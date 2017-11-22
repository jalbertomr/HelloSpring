package com.tutorialspoint;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
    public static void main(String... args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        /*   o tambien
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class,OtraConfig.class);
        context.register(MasConfig.class);
        context.refresh();
        */
        HelloWorld helloWorld = context.getBean(HelloWorld.class);
        helloWorld.setMessage("Hola Perrito Mundo!");
        helloWorld.getMessage();
    }
}
