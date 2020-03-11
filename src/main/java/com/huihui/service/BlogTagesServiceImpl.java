package com.huihui.service;

import com.huihui.domain.BlogTages;
import com.huihui.mapper.BlogTagesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogTagesServiceImpl implements BlogTagesService {

    @Autowired
    private BlogTagesMapper blogTagesMapper ;

    @Override
    public void deletBlogTages(int id) {
        blogTagesMapper.deletBlogTages(id);
    }

    @Override
    public void updateBlogTages(BlogTages blogTages) {
       blogTagesMapper.updateBlogTages(blogTages);
    }

    @Override
    public void insertBlogTages(BlogTages blogTages) {
      blogTagesMapper.insertBlogTages(blogTages);
    }

    @Override
    public void insertBlogTagesList(List<BlogTages> blogTagesList) {
        blogTagesMapper.insertBlogTagesList(blogTagesList);
    }

    @Override
    public BlogTages queryBlogTagesById(int id) {
        return blogTagesMapper.queryBlogTagesById(id);
    }

    @Override
    public List<BlogTages> queryBlogTages() {
        return blogTagesMapper.queryBlogTages();
    }

    @Override
    public List<BlogTages> queryBlogTagesByBlogid(int blogid) {
        return blogTagesMapper.queryBlogTagesByBlogid(blogid);
    }

}
