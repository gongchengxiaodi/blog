package com.huihui.service;

import com.huihui.domain.Tages;
import com.huihui.mapper.TageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagesServiceImpl implements TagesService {

    @Autowired
    private TageMapper tageMapper ;

    @Override
    public Tages queryTagesById(int id) {
        return tageMapper.queryTagesById(id);
    }

    @Override
    public List<Tages> queryTages() {
        return tageMapper.queryTages();
    }

    @Override
    public void insertTages(Tages tages) {
        tageMapper.insertTages(tages);
    }

    @Override
    public void insertTagesList(List<Tages> tages) {
        tageMapper.insertTagesList(tages);
    }

    @Override
    public void updateTages(Tages tages) {
        tageMapper.updateTages(tages);
    }

    @Override
    public void deleteTages(int id) {
        tageMapper.deleteTages(id);
    }

    @Override
    public List<Tages> queryTagesBlog() {
        return tageMapper.queryTagesBlog();
    }
}
