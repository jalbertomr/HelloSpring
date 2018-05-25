package com.project.service.impl;

import com.project.dao.ServiceDAO;
import com.project.dao.StudentDAO;
import com.project.model.Student;
import com.project.model.StudentMarks;
import com.project.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;
    private ServiceDAO serviceDAO;

    public void setStudentDAO(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public void setServiceDAO(ServiceDAO serviceDAO) {
        this.serviceDAO = serviceDAO;
    }

    //@Override
    public void create(String name, Integer age) {
        studentDAO.create(name, age);
    }
    public void create(String name, Integer age, Integer marks, Integer year){ serviceDAO.create(name, age, marks, year);}

    public int updateStudent(Integer id, Integer age){ return serviceDAO.updateStudent(id,age);}
    public List<StudentMarks> listStudentsMarks() { return serviceDAO.listStudentsMarks(); }

    public void createGroup(Student[] students) { studentDAO.createGrupo(students);}

    public void createGroup(List<Student> students) { studentDAO.createGrupo(students);}
    //@Override
    public void deleteAll() {
        serviceDAO.deleteAll();
    }

}
