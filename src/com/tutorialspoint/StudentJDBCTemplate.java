package com.tutorialspoint;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObj;
    private SimpleJdbcCall jdbcCall;

    @Override
    public void setDataSource(DataSource ds) {
      this.dataSource = ds;
      this.jdbcTemplateObj = new JdbcTemplate(ds);
      this.jdbcCall = new SimpleJdbcCall(ds).withProcedureName("getRecord");
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

    public Student getStudentStoreProc(Integer id){
        SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
        Map<String, Object> out = jdbcCall.execute(in);

        Student student = new Student();
        student.setId(id);
        student.setName((String)out.get("out_name"));
        student.setAge((Integer)out.get("out_age"));
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
