package com.project.dao.mapper;

import com.project.model.Marks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MarksMapper implements RowMapper<Marks>{
    //@Override
    public Marks mapRow(ResultSet rs, int i) throws SQLException {
        Marks marks = new Marks();

        marks.setSid(rs.getInt("sid"));
        marks.setMarks(rs.getInt("marks"));
        marks.setYear(rs.getInt("year"));
        return marks;
    }
}

