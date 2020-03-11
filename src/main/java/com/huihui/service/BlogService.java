package com.huihui.service;

import com.github.pagehelper.PageInfo;
import com.huihui.domain.Blog;
import com.huihui.domain.BlogSimpl;

import java.util.List;
import java.util.Map;

public interface BlogService {

    public void insertBlog(Blog blog);
    public void updateBlog(Blog blog);
    public void deleteBlog(int id);
    public int queryBlogByTitle(String title);
    public  Blog queryBlogById( int id );
    public List<Blog> queryBlogs() ;
    public List<Blog> searchBlogs(BlogSimpl blogSimpl);
    public List<Blog> queryBlogsView() ;
    public List<Blog> queryBlogShare(Boolean share);
    public  List<Blog> queryBlogBySerarch(String search);
    public List<Blog> queryBlogByTypoid(Integer typoid);
    public List<Blog> queryBlogByTagesid(Integer tagesid);
    public Map<Integer, PageInfo<Blog>> queryBlogsArchivew(Integer startIndex);
    public int queryCount();
    public List<Blog> queryBlogFoot();
    public void updateCount(Integer id,Integer count);
}
