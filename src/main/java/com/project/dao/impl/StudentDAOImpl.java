package com.project.dao.impl;

import com.project.dao.StudentDAO;
import com.project.dao.mapper.StudentMapper;
import com.project.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class StudentDAOImpl implements StudentDAO {
    private JdbcTemplate jdbcTemplate;
//    private SimpleJdbcCall jdbcCall;

    //PORXMLConfig this.jdbcCall = new SimpleJdbcCall(ds).withProcedureName("getRecord");

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    /*    public void setJdbcCall(SimpleJdbcCall jdbcCall) {
            this.jdbcCall = jdbcCall;
        }
    */
    //@Override
    public int create(String name, Integer age) {
        try {
            String SQL1 = "insert into student (name, age) values (?,?)";
            System.out.println(SQL1);
            jdbcTemplate.update( SQL1, name, age);

            //obten el ultimo id de student para ser usado en la tabla marks
            String SQL2 = "select max(id) from student";
            int sid = jdbcTemplate.queryForObject(SQL2, int.class);
            return sid;
        }catch(DataAccessException e){
            System.out.println("Error al crear registro, Rolling Back " + e);
            throw e;
        }
    }

    public void createGrupo(Student[] students){
        for ( Student student: students ) {
            System.out.println("en createGrupo(Student[] students) for");
            if (student != null) {
                create(student.getName(), student.getAge());
            }
        }
        /*System.out.println("lanza RunTimeException() para no completar la transaccion");
        throw new RuntimeException();*/
    }

    public void createGrupo(List<Student> students){
        Student student;
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            student = iterator.next();
            create(student.getName(),student.getAge());
        }
        System.out.println("lanza RunTimeException() para no completar la transaccion");
        throw new RuntimeException();
    }

    //@Override
    public Student getStudent(Integer id) {
        String SQL = "select * from student where id = ?";
        Student student = jdbcTemplate.queryForObject(SQL, new Object[]{id}, new StudentMapper());
        return student;
    }

    /*    public Student getStudentStoreProc(Integer id){
            SqlParameterSource in = new MapSqlParameterSource().addValue("in_id", id);
            Map<String, Object> out = jdbcCall.execute(in);

            Student student = new Student();
            student.setId(id);
            student.setName((String)out.get("out_name"));
            student.setAge((Integer)out.get("out_age"));
            return student;
        }
    */
    //@Override
    public List<Student> listStudents() {
        String SQL = "select * from student";
        List<Student> students = jdbcTemplate.query(SQL, new StudentMapper());
        return students;
    }

    //@Override
    public int delete(Integer id) {
        String SQL = "delete from student where id = ?";
        int result = jdbcTemplate.update(SQL, id);
        System.out.println("registro Borrado con id: " + id);
        return result;
    }

    //@Override
    public int deleteAll() {
        String SQL = "delete from student";
        int result = jdbcTemplate.update(SQL);
        System.out.println("deleteAll() result: " + result);
        return result;
    }

    //@Override
    public int update(Integer id, Integer age) {
        String SQL = "update student set age = ? where id = ?";
        int result = jdbcTemplate.update(SQL, age, id);
        System.out.println("registro actualizado con id: " + id);
        return result;
    }
}
