package com.project.service;

import com.project.model.Student;

import java.util.List;

public interface StudentService {
    public void create(String name, Integer age);
    public void createGroup(Student[] students);
    public void createGroup(List<Student> students);
    public void deleteAll();
    //public List<Marks> listStudentsMarks();
}
