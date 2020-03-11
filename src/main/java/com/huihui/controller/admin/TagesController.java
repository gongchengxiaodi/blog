package com.huihui.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.Tages;
import com.huihui.service.TagesService;
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
public class TagesController {

    @Autowired
    private TagesService tagesService ;

    @GetMapping("/tages")
    public String tages(Model model,@RequestParam(name = "startIndex",defaultValue = "1") Integer startIndex){
        PageHelper.startPage(startIndex,5);
        List<Tages> tages = tagesService.queryTages();
        PageInfo<Tages> tagesPageInfo = new PageInfo<Tages>(tages,5);
        model.addAttribute("tagesPageInfo",tagesPageInfo);
        return "admin/tages";
    }

    @GetMapping("/toTagesInsert")
    public String toTagesInsert(){
        return "admin/tages-insert";
    }

    @PostMapping("/tagesInsert")
    public String tagesInsert(String name){
        tagesService.insertTages(new Tages(name));
        return "redirect:/admin/tages";
    }


    @GetMapping("/toTagesUpdate")
    public String toTagesUpdate(@RequestParam("id")Integer id , Model model){
        Tages tages = tagesService.queryTagesById(id);
        model.addAttribute("tages",tages);
        return "admin/tages-update";
    }

    @PostMapping("/tagesUpdate")
    public String tagesUpdate(Tages tages){
        tagesService.updateTages(tages);
        return "redirect:/admin/tages";
    }


    @GetMapping("/tagesdelete")
    public String tagesdelete(@RequestParam("id") Integer id){
        tagesService.deleteTages(id);
        return "redirect:/admin/tages";
    }

}
