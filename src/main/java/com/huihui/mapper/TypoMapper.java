package com.huihui.mapper;

import com.huihui.domain.Typo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypoMapper {

    public Typo queryTypoById(int id);
    public List<Typo> queryTypos();
    public void insertTypo(Typo typo);
    public void updateTypo(Typo typo);
    public void deleteTypo(int id);
    public List<Typo> queryTypoBlod();
}
