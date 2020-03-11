package com.huihui.domain;

import java.sql.Timestamp;
import java.util.List;

/*
*用户实体类
* */
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String imgurl;
    private Timestamp createDate;
    private Timestamp updatDate;
    private List<Blog> blogs;

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String nickname, String email, String imgurl, Timestamp createDate, Timestamp updatDate, List<Blog> blogs) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
        this.imgurl = imgurl;
        this.createDate = createDate;
        this.updatDate = updatDate;
        this.blogs = blogs;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdatDate() {
        return updatDate;
    }

    public void setUpdatDate(Timestamp updatDate) {
        this.updatDate = updatDate;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", createDate=" + createDate +
                ", updatDate=" + updatDate +
                ", blogs=" + blogs +
                '}';
    }
}
