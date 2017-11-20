package com.tutorialspoint;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
    public static void main(String... args) {
        FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("C:\\Users\\Bext\\Desktop\\HelloSpring\\src\\Beans.xml");

        HelloWorld o = (HelloWorld) context.getBean("helloWorld");
        o.getMessage();
    }
}
