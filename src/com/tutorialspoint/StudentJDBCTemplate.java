package com.tutorialspoint;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObj;

    @Override
    public void setDataSource(DataSource ds) {
      this.dataSource = ds;
      this.jdbcTemplateObj = new JdbcTemplate(ds);
    }

    @Override
    public void create(String name, Integer age) {
        String SQL = "insert into student (name, age) values (?,?)";
        jdbcTemplateObj.update( SQL, name, age);
        System.out.println("registro creado name: " + name + " age: " + age);
        return;
    }

    @Override
    public Student getStudent(Integer id) {
        String SQL = "select * from student where id = ?";
        Student student = jdbcTemplateObj.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return student;
    }

    @Override
    public List<Student> listStudents() {
        String SQL = "select * from student";
        List<Student> students = jdbcTemplateObj.query(SQL, new StudentMapper());
        return students;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from student where id = ?";
        jdbcTemplateObj.update(SQL, id);
        System.out.println("registro Borrado con id: " + id);
        return;
    }

    @Override
    public void update(Integer id, Integer age) {
        String SQL = "update student set age = ? where id = ?";
        jdbcTemplateObj.update(SQL, age, id);
        System.out.println("registro actualizado con id: " + id);
        return;
    }
}
