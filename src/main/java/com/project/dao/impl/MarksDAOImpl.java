package com.project.dao.impl;

import com.project.dao.MarksDAO;
import com.project.dao.mapper.MarksMapper;
import com.project.model.Marks;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MarksDAOImpl implements MarksDAO {
    private JdbcTemplate jdbcTemplate;
    static Logger log = LogManager.getLogger(MarksDAOImpl.class);

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate2) {
        this.jdbcTemplate = jdbcTemplate2;
    }

    public void create(Integer sid, Integer marks, Integer year) {
        try {
            log.trace("MarksDAO creando marks:" + marks + " " + year +"...");
            String SQL3 = "insert into marks(sid, marks, year) values (?,?,?)";
            jdbcTemplate.update( SQL3, sid, marks, year);
            log.trace("creado.!");

            //throw new RuntimeException("Condicion de Error simulado");
        }catch(DataAccessException e){
            log.error("Error al crear registro, Rolling Back " + e);
            throw e;
        }
    }

    public List<Marks> listMarks(Integer sid) {
        String SQL = "select * from marks where sid = ?";
        List<Marks> marks = jdbcTemplate.query(SQL, new MarksMapper(), sid);
        return marks;
    }

    public int deleteAll() {
            String SQL = "delete from marks";
            int result = jdbcTemplate.update(SQL);
            log.trace("marksDAO.deleteAll() result : " + result);
            return result;
    }

    public int deleteAll(Integer sid) {
        String SQL = "delete from student where sid = ?";
        int result = jdbcTemplate.update(SQL, sid);
        log.trace("marksDAO.deleteAll(" + sid + ") result: " + result);
        return result;
    }

}
