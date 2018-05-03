package com.tutorialspoint;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

public class StudentJDBCTemplate implements StudentDAO {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObj;
    private SimpleJdbcCall jdbcCall;
    private PlatformTransactionManager transactionManager;

    @Override
    public void setDataSource(DataSource ds) {
      this.dataSource = ds;
      this.jdbcTemplateObj = new JdbcTemplate(ds);
     // this.jdbcCall = new SimpleJdbcCall(ds).withProcedureName("getRecord");
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager){
        this.transactionManager = transactionManager;
    }

    @Override
    public void create(String name, Integer age, Integer marks, Integer year) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String SQL1 = "insert into student (name, age) values (?,?)";
            System.out.println(SQL1);
            jdbcTemplateObj.update( SQL1, name, age);

            //obten el ultimo id de student para ser usado en la tabla marks
            String SQL2 = "select max(id) from student";
            int sid = jdbcTemplateObj.queryForObject(SQL2, int.class);

            String SQL3 = "insert into marks(sid, marks, year) values (?,?,?)";
            jdbcTemplateObj.update( SQL3, sid, marks, year);
            System.out.println("registro creado name: " + name + " age: " + age);

            transactionManager.commit(status);
        }catch(DataAccessException e){
            System.out.println("Error al crear registro, Rolling Back " + e);
            transactionManager.rollback(status);
            throw e;
        }
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

    public List<StudentMarks> listStudentsMarks(){
        String SQL = "select * from student s, marks m where s.id=m.sid";
        List<StudentMarks> studentMarks = jdbcTemplateObj.query(SQL, new StudentMarksMapper());
        return studentMarks;
    }

    @Override
    public void delete(Integer id) {
        String SQL = "delete from student where id = ?";
        jdbcTemplateObj.update(SQL, id);
        System.out.println("registro Borrado con id: " + id);
        return;
    }

    @Override
    public void deleteAll() {
        String SQL = "delete from student";
        int result =jdbcTemplateObj.update(SQL);
        System.out.println("tabla student eliminados todos los registros result:" + result);
        SQL = "delete from marks";
        result = jdbcTemplateObj.update(SQL);
        System.out.println("tabla marks eliminados todos los registros result: " + result);
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
