package com.project.dao;



import com.project.model.Student;

import java.util.List;

public interface StudentDAO {
    public int create(String name, Integer age);
    public void createGrupo(Student[] students);
    public void createGrupo(List<Student> students);
    public Student getStudent(Integer id);
    public List<Student> listStudents();
    public int delete(Integer id);
    public int deleteAll();
    public int update(Integer id, Integer age);
    public Student getStudentStoreProc(Integer id);
}
