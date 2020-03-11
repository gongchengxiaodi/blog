package com.huihui.service;

import com.huihui.domain.Typo;
import com.huihui.mapper.TypoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypoServiceImpl implements TypoService {

    @Autowired
    private TypoMapper typoMapper ;


    @Override
    public Typo queryTypoById(int id) {
        return typoMapper.queryTypoById(id);
    }

    @Override
    public List<Typo> queryTypos() {
        return typoMapper.queryTypos();
    }

    @Override
    public void insertTypo(Typo typo) {
        typoMapper.insertTypo(typo);
    }

    @Override
    public void updateTypo(Typo typo) {
        typoMapper.updateTypo(typo);
    }

    @Override
    public void deleteTypo(int id) {
       typoMapper.deleteTypo(id);
    }

    @Override
    public List<Typo> queryTypoBlod() {
        return typoMapper.queryTypoBlod();
    }
}
