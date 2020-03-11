package com.huihui.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.Blog;
import com.huihui.domain.Tages;
import com.huihui.service.BlogService;
import com.huihui.service.TagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TagesViewController {

    @Autowired
    private TagesService tagesService ;
    @Autowired
    private BlogService blogService ;

    @RequestMapping("/tages")
    public String tages(@RequestParam("id") Integer id, Model model,
                        @RequestParam(name = "startIndex",defaultValue = "1")
                                Integer startIndex){
        List<Tages> tages = tagesService.queryTagesBlog();
        if(id == -1){
            id = tages.get(0).getId();
        }
        PageHelper.startPage(startIndex,5);
        List<Blog> blogs = blogService.queryBlogByTagesid(id);
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogs);
        model.addAttribute("tages",tages);
        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("activeId",id);
        return "view/tags";
    }

}
