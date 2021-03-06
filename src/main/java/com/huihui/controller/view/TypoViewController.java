package com.huihui.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.Blog;
import com.huihui.domain.Typo;
import com.huihui.service.BlogService;
import com.huihui.service.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TypoViewController {

    @Autowired
    private TypoService typoService ;
    @Autowired
    private BlogService blogService ;

    @RequestMapping("/typo")
    public String typo(@RequestParam("id") Integer id, Model model,
                       @RequestParam(name = "startIndex",defaultValue = "1")
                               Integer startIndex){
        List<Typo> typos = typoService.queryTypoBlod();
        if(id == -1){
            id = typos.get(0).getId();
        }
        PageHelper.startPage(startIndex,5);
        List<Blog> blogs = blogService.queryBlogByTypoid(id);
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogs);
        model.addAttribute("typos",typos);
        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("activeId",id);
        return "view/typo";
    }

}
