package com.huihui.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.Blog;
import com.huihui.domain.Tages;
import com.huihui.domain.Typo;
import com.huihui.service.BlogService;
import com.huihui.service.TagesService;
import com.huihui.service.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService ;
    @Autowired
    private TypoService typoService ;
    @Autowired
    private TagesService tagesService ;

    @RequestMapping({"/","/index"})
   public String index(Model model,@RequestParam(name = "startIndex",defaultValue = "1") Integer startIndex){
        List<Typo> typos = typoService.queryTypoBlod();
        List<Tages> tages = tagesService.queryTagesBlog();
        PageHelper.startPage(startIndex,5);
        List<Blog> blogs = blogService.queryBlogsView();
        List<Blog> shareBlogs = blogService.queryBlogShare(true);
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogs);
        PageInfo<Blog> sharePageInfo = new PageInfo<Blog>(shareBlogs);
        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("typos",typos);
        model.addAttribute("tages",tages);
        model.addAttribute("sharePageInfo",sharePageInfo);
        return "view/index";
   }

   @RequestMapping("/toFoot")
   public String toFoot(Model model){
       List<Blog> blogs = blogService.queryBlogFoot();
       model.addAttribute("blogs",blogs);
       return "comment/comment :: test";
   }

}
