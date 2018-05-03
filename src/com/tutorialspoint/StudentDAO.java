package com.tutorialspoint;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDAO {
    public void setDataSource(DataSource ds);
    public void create(String name, Integer age, Integer marks, Integer year);
    public Student getStudent(Integer id);
    public List<Student> listStudents();
    public List<StudentMarks> listStudentsMarks();
    public void delete(Integer id);
    public void deleteAll();
    public void update(Integer id, Integer age);
}
