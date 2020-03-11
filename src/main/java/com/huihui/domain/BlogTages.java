package com.huihui.domain;

public class BlogTages {

    private Integer id ;
    private Integer blogid ;
    private Integer tagesid ;

    public BlogTages(Integer blogid, Integer tagesid) {
        this.blogid = blogid;
        this.tagesid = tagesid;
    }

    public BlogTages() {
    }

    public BlogTages(Integer id, Integer blogid, Integer tagesid) {
        this.id = id;
        this.blogid = blogid;
        this.tagesid = tagesid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogid() {
        return blogid;
    }

    public void setBlogid(Integer blogid) {
        this.blogid = blogid;
    }

    public Integer getTagesid() {
        return tagesid;
    }

    public void setTagesid(Integer tagesid) {
        this.tagesid = tagesid;
    }

    @Override
    public String toString() {
        return "BlogTages{" +
                "id=" + id +
                ", blogid=" + blogid +
                ", tagesid=" + tagesid +
                '}';
    }
}
