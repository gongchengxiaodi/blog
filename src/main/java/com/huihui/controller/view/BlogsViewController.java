package com.huihui.controller.view;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.Blog;
import com.huihui.service.BlogService;
import com.huihui.utils.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogsViewController {


    @Autowired
    private BlogService blogService ;

    @GetMapping("/toblogById")
    public String toblogById(Integer id, Model model){
        Blog blog = blogService.queryBlogById(id);
        int count = blog.getCount()+1;
        blogService.updateCount(id,count);
        Blog b = new Blog();
        BeanUtils.copyProperties(blog,b);
        String content = b.getContent();
        b.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        model.addAttribute("blog",b);
        return "view/blog";
    }


    @GetMapping("/toTagesById")
    public String toTagesById(Integer id){
        return "view/tags";
    }

    @GetMapping("/toTypoById")
    public String toTypoById(Integer id){
        return "typo";
    }

    @RequestMapping("/toSearch")
    public String toSearch(@RequestParam("search") String search, Model model,
                           @RequestParam(name = "startIndex",defaultValue = "1")
                                   Integer startIndex){
        PageHelper.startPage(startIndex,5);
        List<Blog> blogs = blogService.queryBlogBySerarch(search);
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogs);
        model.addAttribute("blogPageInfo",blogPageInfo);
        model.addAttribute("search",search);
        return "view/search";
    }

}
