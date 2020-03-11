package com.huihui.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.huihui.domain.Blog;
import com.huihui.domain.BlogSimpl;
import com.huihui.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper ;


    @Override
    public void insertBlog(Blog blog) {
       blogMapper.insertBlog(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }

    @Override
    public void deleteBlog(int id) {
        blogMapper.deleteBlog(id);
    }

    @Override
    public int queryBlogByTitle(String title) {
        return blogMapper.queryBlogByTitle(title);
    }

    @Override
    public Blog queryBlogById(int id) {
        return blogMapper.queryBlogById(id);
    }

    @Override
    public List<Blog> queryBlogs() {
        return blogMapper.queryBlogs();
    }

    @Override
    public List<Blog> searchBlogs(BlogSimpl blogSimpl) {
        return blogMapper.searchBlogs(blogSimpl);
    }

    @Override
    public List<Blog> queryBlogsView() {
        return blogMapper.queryBlogsView();
    }

    @Override
    public List<Blog> queryBlogShare(Boolean share) {
        return blogMapper.queryBlogShare(share);
    }

    @Override
    public List<Blog> queryBlogBySerarch(String search) {
        return blogMapper.queryBlogBySerarch(search);
    }

    @Override
    public List<Blog> queryBlogByTypoid(Integer typoid) {
        return blogMapper.queryBlogByTypoid(typoid);
    }

    @Override
    public List<Blog> queryBlogByTagesid(Integer tagesid) {
        return blogMapper.queryBlogByTagesid(tagesid);
    }

    @Override
    public Map<Integer,  PageInfo<Blog>> queryBlogsArchivew(Integer startIndex) {
        HashMap<Integer,  PageInfo<Blog>> map = new HashMap<>();
        ArrayList<Integer> years = blogMapper.queryYears();
        for (Integer year : years) {
            PageHelper.startPage(startIndex,10);
            List<Blog> blogs = blogMapper.queryBlogByYear(year);
            PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
            map.put(year,pageInfo);
        }
        return map ;
    }




    @Override
    public int queryCount() {
        return blogMapper.queryCount();
    }

    @Override
    public List<Blog> queryBlogFoot() {
        return blogMapper.queryBlogFoot();
    }

    @Override
    public void updateCount(Integer id, Integer count) {
      blogMapper.updateCount(id,count);
    }
}
