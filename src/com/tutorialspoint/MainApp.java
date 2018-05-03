package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        System.out.println("---- creando registros -----");
        studentJDBCTemplate.create("Juan",23);
        studentJDBCTemplate.create("Lucia", 21);
        studentJDBCTemplate.create("Fulanita", 34);

        System.out.println("---- Desplegando multiples registros ----");
        List<Student> students = studentJDBCTemplate.listStudents();
        for (Student record: students){
            System.out.print("ID: " + record.getId());
            System.out.print(", name: " + record.getName());
            System.out.println(", age: " + record.getAge());
        }

        System.out.println("---- desplegando registro con id = 2");
        Student student = studentJDBCTemplate.getStudentStoreProc(2);
        System.out.print("ID: " + student.getId());
        System.out.print(", name: " + student.getName());
        System.out.println(", age: " + student.getAge());

        System.out.println("---- Actualizando registro con id = 2");
        studentJDBCTemplate.update(2,30);

        System.out.println("---- desplegando registro con id = 2");
        student = studentJDBCTemplate.getStudentStoreProc(2);
        System.out.print("ID: " + student.getId());
        System.out.print(", name: " + student.getName());
        System.out.println(", age: " + student.getAge());

    }
}
