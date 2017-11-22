package com.tutorialspoint;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
    public static void main(String... args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        //Disparamos un evento Start
        context.start();

        HelloWorld o = (HelloWorld) context.getBean("helloWorld");
        o.getMessage();

        //Disparamos un evento Stop
        context.stop();
    }
}
