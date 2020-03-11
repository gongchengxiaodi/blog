package com.huihui.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.*;
import com.huihui.service.BlogService;
import com.huihui.service.BlogTagesService;
import com.huihui.service.TagesService;
import com.huihui.service.TypoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class BlogsController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypoService typoService;
    @Autowired
    private TagesService tagesService;
    @Autowired
    private BlogTagesService blogTagesService;

    @RequestMapping("/blogs")
    public String blogs(Model model, @RequestParam(name = "startIndex", defaultValue = "1") Integer startIndex) {
        List<Typo> typos = typoService.queryTypos();
        model.addAttribute("typos", typos);
        PageHelper.startPage(startIndex, 5);
        List<Blog> blogs = blogService.queryBlogs();
        PageInfo<Blog> blogPageInfo = new PageInfo<Blog>(blogs, 5);
        model.addAttribute("blogPageInfo", blogPageInfo);
        return "admin/blogs";
    }

    @RequestMapping("/bloginput")
    public String bloginput() {
        return "admin/blogs-input";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Blog> serarch(BlogSimpl simpl) {
        List<Blog> searchBlogs = blogService.searchBlogs(simpl);
        return searchBlogs;
    }

    @GetMapping("/toBlogsInput")
    public String toBlogsInput(Model model) {
        List<Typo> typos = typoService.queryTypos();
        List<Tages> tages = tagesService.queryTages();
        model.addAttribute("typos", typos);
        model.addAttribute("tages", tages);
        return "admin/blogs-input";
    }

    @PostMapping("/toBlogsInsert")
    @Transactional  //开启事务
    public String toBlogsInsert(Blog blog, HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setCreateDate(new Timestamp(new Date().getTime()));
        blog.setUpdateDate(new Timestamp(new Date().getTime()));
        blog.setCount(0);
        blog.setTypo(typoService.queryTypoById(blog.getTypoid()));
        blogService.insertBlog(blog);
        //好像可能会出现异步问题
        List<Tages> tagesList = blog.getTagesList();
        for (Tages tages : tagesList) {
            blogTagesService.insertBlogTages(new BlogTages(blogService.queryBlogByTitle(blog.getTitle()), Integer.decode(tages.getName())));
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/toBlogsUpdate")
    public String toBlogsUpdate(Integer id, Model model) {
        Blog blog = blogService.queryBlogById(id);
        List<Typo> typos = typoService.queryTypos();
        List<Tages> tages = tagesService.queryTages();
        List<Tages> tagesList = blog.getTagesList();
        StringBuffer tagesid = new StringBuffer();
        Boolean flag = false;
        for (Tages tages1 : tagesList) {
            if (flag) {
                tagesid.append(",");
            } else {
                flag = true;
            }
            tagesid.append(tages1.getId());
        }
        model.addAttribute("typos", typos);
        model.addAttribute("tages", tages);
        model.addAttribute("blog", blog);
        model.addAttribute("tagesid", tagesid.toString());
        return "admin/blogs-update";
    }

    @PostMapping("/blogsUpdate")
    @Transactional
    public String blogsUpdate(Blog blog) {
        blog.setUpdateDate(new Timestamp(new Date().getTime()));
        blog.setTypo(typoService.queryTypoById(blog.getTypoid()));
        blogService.updateBlog(blog);

        List<Tages> tagesList = blog.getTagesList();
        List<BlogTages> blogTagesList = blogTagesService.queryBlogTagesByBlogid(blog.getId());
        for (BlogTages blogTageS : blogTagesList) {
            blogTagesService.deletBlogTages(blogTageS.getId());
        }
        for (Tages tages : tagesList) {
            blogTagesService.insertBlogTages(new BlogTages(blogService.queryBlogByTitle(blog.getTitle()), Integer.decode(tages.getName())));
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/deleteBlog")
    @Transactional
    public String deleteBlog(int id) {
        List<BlogTages> blogTagesList = blogTagesService.queryBlogTagesByBlogid(id);
        for (BlogTages blogTageS : blogTagesList) {
            blogTagesService.deletBlogTages(blogTageS.getId());
        }
        blogService.deleteBlog(id);
        return "redirect:/admin/blogs";
    }
}
