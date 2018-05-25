package com.project.dao;

import com.project.model.Marks;
import com.project.model.StudentMarks;

import java.util.List;

public interface ServiceDAO {
    public int deleteAll();
    public void create(String name, Integer age, Integer marks, Integer year);
    public int updateStudent(Integer id, Integer age);
    public List<StudentMarks> listStudentsMarks();
}
