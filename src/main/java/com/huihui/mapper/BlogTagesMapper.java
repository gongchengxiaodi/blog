package com.huihui.mapper;

import com.huihui.domain.BlogTages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BlogTagesMapper {

    public void deletBlogTages(@Param("id") int id);
    public void updateBlogTages(BlogTages blogTages);
    public void insertBlogTages(BlogTages blogTages);
    public void insertBlogTagesList(List<BlogTages> blogTagesList);
    public BlogTages queryBlogTagesById(@Param("id") int id);
    public List<BlogTages> queryBlogTagesByBlogid(int blogid);
    public List<BlogTages> queryBlogTages();

}
