package com.project.dao.mapper;

import com.project.model.Marks;
import com.project.model.Student;
import com.project.model.StudentMarks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMarksMapper implements RowMapper<StudentMarks> {
    //@Override
    public StudentMarks mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentMarks studentMarks = new StudentMarks();
        Student student = new Student();
        Marks marks = new Marks();
        student.setId(resultSet.getInt("id"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));
        marks.setSid(resultSet.getInt("sid"));
        marks.setMarks(resultSet.getInt("marks"));
        marks.setYear(resultSet.getInt("year"));
        studentMarks.setStudent(student);
        studentMarks.setMarks(marks);
        return studentMarks;
    }
}
