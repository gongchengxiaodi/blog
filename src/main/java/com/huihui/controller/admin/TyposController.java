package com.huihui.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.Typo;
import com.huihui.service.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TyposController {

    @Autowired
    private TypoService typoService ;


    @GetMapping("/typos")
    public String typos(Model model,@RequestParam(name = "startIndex",defaultValue = "1") Integer startIndex){
        PageHelper.startPage(startIndex,5);
        List<Typo> typos = typoService.queryTypos();
        PageInfo<Typo> typoPageInfo = new PageInfo<Typo>(typos,5);
        model.addAttribute("typoPageInfo",typoPageInfo);
        return "admin/typos";
    }

    @GetMapping("/toTyposInsert")
    public String toTyposInsert(){
        return "admin/typos-insert";
    }

    @PostMapping("/typosInsert")
    public String typosInsert(String name){
        typoService.insertTypo(new Typo(name));
        return "redirect:/admin/typos";
    }


    @GetMapping("/toTyposUpdate")
    public String toTyposUpdate(@RequestParam("id")Integer id , Model model){
        Typo typo = typoService.queryTypoById(id);
        model.addAttribute("typo",typo);
        return "admin/typos-update";
    }

    @PostMapping("/typosUpdate")
    public String typosUpdate(Typo typo){
        typoService.updateTypo(typo);
        return "redirect:/admin/typos";
    }


    @GetMapping("/typosdelete")
    public String typosdelete(@RequestParam("id") Integer id){
        typoService.deleteTypo(id);
        return "redirect:/admin/typos";
    }



}
