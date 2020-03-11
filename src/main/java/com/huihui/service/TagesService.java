package com.huihui.service;

import com.huihui.domain.Tages;

import java.util.List;

public interface TagesService {

    public Tages queryTagesById(int id);
    public List<Tages> queryTages();
    public void insertTages(Tages tages);
    public void insertTagesList(List<Tages> tages);
    public void updateTages(Tages tages);
    public void deleteTages(int id);
    public List<Tages> queryTagesBlog();
}
