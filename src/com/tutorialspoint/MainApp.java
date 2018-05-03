package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String... args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
        System.out.println("---- Borrando todos los registros -----");
        studentJDBCTemplate.deleteAll();

        System.out.println("---- creando registros -----");
        studentJDBCTemplate.create("Juan",23, 89, 2014);
        studentJDBCTemplate.create("Lucia", 21, 95, 2017);
        studentJDBCTemplate.create("Fulanita", 34, 100, 2018);

        System.out.println("---- Desplegando multiples registros ----");
        List<StudentMarks> studentsMarks = studentJDBCTemplate.listStudentsMarks();
        for (StudentMarks record: studentsMarks){
            System.out.print("ID: " + record.getId());
            System.out.print(", name: " + record.getName());
            System.out.println(", age: " + record.getAge());
            System.out.println(", mark: " + record.getMarks());
            System.out.println(", year: " + record.getYear());
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
