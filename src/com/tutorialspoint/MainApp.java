package com.tutorialspoint;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class MainApp {
    public static void main(String... args) {
        XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("Beans.xml"));

        HelloWorld o = (HelloWorld) factory.getBean("helloWorld");
        o.getMessage();
    }
}
