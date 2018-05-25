package com.project.service;

import com.project.model.Student;
import com.project.model.StudentMarks;

import java.util.List;

public interface StudentService {
    public void create(String name, Integer age);
    public void create(String name, Integer age, Integer marks, Integer year);
    public void createGroup(Student[] students);
    public void createGroup(List<Student> students);
    public int updateStudent(Integer id, Integer age);
    public void deleteAll();
    public List<StudentMarks> listStudentsMarks();
}
