package com.huihui.service;

import com.huihui.domain.BlogTages;

import java.util.List;

public interface BlogTagesService {
    public void deletBlogTages( int id);
    public void updateBlogTages(BlogTages blogTages);
    public void insertBlogTages(BlogTages blogTages);
    public void insertBlogTagesList(List<BlogTages> blogTagesList);
    public BlogTages queryBlogTagesById( int id);
    public List<BlogTages> queryBlogTages();
    public List<BlogTages> queryBlogTagesByBlogid(int blogid);
}
