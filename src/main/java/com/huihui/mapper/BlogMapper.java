package com.huihui.mapper;

import com.huihui.domain.Blog;
import com.huihui.domain.BlogSimpl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface BlogMapper {
    //
    public void insertBlog(Blog blog);
    public void updateBlog(Blog blog);
    public void deleteBlog(int id);
    public int queryBlogByTitle(String title);
    public Blog queryBlogById( @Param("id") int id );
    public List<Blog> queryBlogs() ;
    public List<Blog> queryBlogsView() ;
    public List<Blog> searchBlogs(BlogSimpl blogSimpl);
    public List<Blog> queryBlogShare(Boolean share);
    public  List<Blog> queryBlogBySerarch(String search);
    public List<Blog> queryBlogByTypoid(Integer typoid);
    public List<Blog> queryBlogByTagesid(Integer tagesid);
    public ArrayList<Integer> queryYears();
    public List<Blog> queryBlogByYear(Integer year);
    public int queryCount();
    public List<Blog> queryBlogFoot();
    public void updateCount(Integer id,Integer count);
}
