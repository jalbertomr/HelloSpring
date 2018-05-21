package com.project.client;

import com.project.model.Student;
import com.project.service.StudentService;
import com.project.service.impl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String... args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentService studentService = context.getBean("studentService", StudentServiceImpl.class);

        System.out.println("---- Borrando todos los registros -----");
        studentService.deleteAll();

        System.out.println("---- creando registros -----");
        studentService.create("Juan1",23);
        studentService.create("Lucia2", 21);
        studentService.create("Fulanita3", 34);

        Student[] arr_students = new Student[10];
        arr_students[0] = new Student("Lucas4", 13);
        arr_students[1] = new Student("Lety5", 25);
        arr_students[2] = new Student("Giovana6", 30);
        studentService.createGroup(arr_students);

        List<Student> list_students = new ArrayList<Student>();
        list_students.add(new Student("Juanita7",12));
        list_students.add(new Student("Panfila8",22));
        list_students.add(new Student("Filomeno9",46));
        studentService.createGroup(list_students);

/*
        System.out.println("---- creando registros -----");
        studentService.create("Juan",23);
        studentService.create("Lucia", 21);
        studentService.create("Fulanita", 34);
        System.out.println("lanza RunTimeException() para no completar la transaccion");
        throw new RuntimeException();
        */
/*
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
