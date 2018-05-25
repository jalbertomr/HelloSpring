package com.project.client;

import com.project.service.StudentService;
import com.project.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainAppRESP {
    public static void main(String... args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        StudentService studentService = (StudentService) context.getBean("studentService", StudentServiceImpl.class);
//        System.out.println("---- Borrando todos los registros -----");
//        studentService.deleteAll();

/*        System.out.println("---- creando registros -----");
        studentService.create("Juan",23, 89, 2014);
        studentService.create("Lucia", 21, 95, 2017);
        studentService.create("Fulanita", 34, 100, 2018);

        System.out.println("---- Desplegando multiples registros ----");
        List<StudentMarks> studentsMarks = serviceDAO.listStudentsMarks();
        for (StudentMarks record: studentsMarks){
            System.out.print("ID: " + record.getStudent().getId());
            System.out.print(", name: " + record.getStudent().getName());
            System.out.println(", age: " + record.getStudent().getAge());
            System.out.println(", mark: " + record.getMarks().getMarks());
            System.out.println(", year: " + record.getMarks().getYear());
        }

        System.out.println("---- desplegando registro con id = 2");
        Student student = serviceDAO.getStudentStoreProc(2);
        System.out.print("ID: " + student.getId());
        System.out.print(", name: " + student.getName());
        System.out.println(", age: " + student.getAge());

        System.out.println("---- Actualizando registro con id = 2");
        serviceDAO.updateStudent(2,30);

        System.out.println("---- desplegando registro con id = 2");
        student = serviceDAO.getStudentStoreProc(2);
        System.out.print("ID: " + student.getId());
        System.out.print(", name: " + student.getName());
        System.out.println(", age: " + student.getAge());
*/
    }

}
