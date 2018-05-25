package com.project.dao.impl;

import com.project.dao.MarksDAO;
import com.project.dao.ServiceDAO;
import com.project.dao.StudentDAO;
import com.project.dao.mapper.StudentMarksMapper;
import com.project.model.StudentMarks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    JdbcTemplate jdbcTemplate;
    StudentDAO studentDAO;
    MarksDAO marksDAO;
    static Logger log = LogManager.getLogger(ServiceDAOImpl.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void setStudentDAO(StudentDAO studentDAO) { this.studentDAO = studentDAO; }
    public void setMarksDAO(MarksDAO marksDAO) { this.marksDAO = marksDAO; }

    public List<StudentMarks> listStudentsMarks(){
       String SQL = "select * from student s, marks m where s.id=m.sid";
       List<StudentMarks> studentMarks = jdbcTemplate.query(SQL, new StudentMarksMapper());
       return studentMarks;
    }
    //@Override
    public int deleteAll() {
        int result;
        result = marksDAO.deleteAll();
        log.trace("tabla student eliminados todos los registros result:" + result);
        result += studentDAO.deleteAll();
        log.trace("tabla marks eliminados todos los registros result: " + result);
        return result;
    }

    //@Override
    public void create(String name, Integer age, Integer marks, Integer year) {
        int sid = studentDAO.create(name, age);
        marksDAO.create(sid, marks, year);
    }

    public int updateStudent(Integer id, Integer age) {
        return studentDAO.update(id, age);
    }
}
