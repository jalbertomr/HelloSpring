package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();

        Person juan = (Person) context.getBean("Juan");
        System.out.println("Juan nombre: " + juan.getName() + " partner: " + juan.getPartner().getName());

        Person maria = (Person) context.getBean("Maria");
        System.out.println("Maria nombre: " + maria.getName());

    }
}
