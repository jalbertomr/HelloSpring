package com.project.service.impl;

import com.project.dao.StudentDAO;
import com.project.model.Student;
import com.project.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    //@Override
    public void create(String name, Integer age) {
        studentDAO.create(name, age);
    }

    public void createGroup(Student[] students) { studentDAO.createGrupo(students);}

    public void createGroup(List<Student> students) { studentDAO.createGrupo(students);}
    //@Override
    public void deleteAll() {
        studentDAO.deleteAll();
    }

}
