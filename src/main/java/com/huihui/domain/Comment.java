package com.huihui.domain;

import java.sql.Timestamp;
import java.util.List;

/*
* 评论
* */

public class Comment {

    private Integer id ;
    private String  name ;
    private String content ;
    private String email ;
    private Timestamp createDate ;
    private String imgurl ;
    private Blog blog ;
    private List<Comment> replayComment ;
    private Comment parenComment ;


    public Comment() {
    }

    public Comment(Integer id, String name, String content, String email,
                   Timestamp createDate, String imgurl, Blog blog, List<Comment> replayComment,
                   Comment parenComment) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.email = email;
        this.createDate = createDate;
        this.imgurl = imgurl;
        this.blog = blog;
        this.replayComment = replayComment;
        this.parenComment = parenComment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public List<Comment> getReplayComment() {
        return replayComment;
    }

    public void setReplayComment(List<Comment> replayComment) {
        this.replayComment = replayComment;
    }

    public Comment getParenComment() {
        return parenComment;
    }

    public void setParenComment(Comment parenComment) {
        this.parenComment = parenComment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", email='" + email + '\'' +
                ", createDate=" + createDate +
                ", imgurl='" + imgurl + '\'' +
                ", blog=" + blog +
                ", replayComment=" + replayComment +
                ", parenComment=" + parenComment +
                '}';
    }
}
