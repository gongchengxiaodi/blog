package com.huihui.mapper;

import com.huihui.domain.Tages;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TageMapper {

    public Tages queryTagesById(int id);
    public List<Tages> queryTages();
    public void insertTages(Tages tages);
    public void insertTagesList(List<Tages> tages);
    public void updateTages(Tages tages);
    public void deleteTages(int id);
    public List<Tages> queryTagesBlog();
}
