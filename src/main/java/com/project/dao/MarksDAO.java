package com.project.dao;

import com.project.model.Marks;

import java.util.List;

public interface MarksDAO {
    public void create(Integer sid, Integer marks, Integer year);
    public List<Marks> listMarks(Integer sid);
    public int deleteAll();
    public int deleteAll(Integer sid);
}
