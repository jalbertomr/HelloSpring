package com.tutorialspoint;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    public static void main(String... args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        TextEditor textEditor = (TextEditor) context.getBean("textEditor");
        textEditor.spellCheck();

        Foo foo = (Foo) context.getBean("foo");

        Foo fooYearName = (Foo) context.getBean("fooYearName");

        Foo fooIndex0Index1 = (Foo) context.getBean("fooIndex0Index1");
    }
}
