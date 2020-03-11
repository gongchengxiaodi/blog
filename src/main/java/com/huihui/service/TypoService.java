package com.huihui.service;

import com.huihui.domain.Typo;

import java.util.List;

public interface TypoService {

    public Typo queryTypoById(int id);
    public List<Typo> queryTypos();
    public void insertTypo(Typo typo);
    public void updateTypo(Typo typo);
    public void deleteTypo(int id);
    public List<Typo> queryTypoBlod();

}
