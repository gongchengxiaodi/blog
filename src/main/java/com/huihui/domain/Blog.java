package com.huihui.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/*
*博客实体类
* */
public class Blog implements Serializable {

    private Integer id ;
    private String title ;
    private String content ;
    private String imgurl ;
    private String flag ;
    private int count ;
    private Timestamp createDate ;
    private Timestamp updateDate ;
    private Boolean share ;
    private Boolean pay ;
    private Boolean comment ;
    private Boolean copyright ;
    private String describes ;

    private Integer typoid ;


    private User user ;
    private Typo typo ;
    private List<Tages> tagesList ;

    public Blog(String title,User user, Typo typo, List<Tages> tagesList) {
        this.title = title ;
        this.user = user;
        this.typo = typo;
        this.tagesList = tagesList;
    }

    public Blog() {
    }

    public Blog(Integer id, String title, String content, String imgurl,
                String flag, int count, Timestamp createDate, Timestamp updateDate,
                Boolean share, Boolean pay, Boolean comment, Boolean copyright, String describe,
                Integer typoid, User user, Typo typo, List<Tages> tagesList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgurl = imgurl;
        this.flag = flag;
        this.count = count;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.share = share;
        this.pay = pay;
        this.comment = comment;
        this.copyright = copyright;
        this.describes = describes;
        this.typoid = typoid;
        this.user = user;
        this.typo = typo;
        this.tagesList = tagesList;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    public Boolean getShare() {
        return share;
    }

    public void setShare(Boolean share) {
        this.share = share;
    }

    public Boolean getPay() {
        return pay;
    }

    public void setPay(Boolean pay) {
        this.pay = pay;
    }

    public Boolean getComment() {
        return comment;
    }

    public void setComment(Boolean comment) {
        this.comment = comment;
    }

    public Boolean getCopyright() {
        return copyright;
    }

    public void setCopyright(Boolean copyright) {
        this.copyright = copyright;
    }

    public Integer getTypoid() {
        return typoid;
    }

    public void setTypoid(Integer typoid) {
        this.typoid = typoid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Typo getTypo() {
        return typo;
    }

    public void setTypo(Typo typo) {
        this.typo = typo;
    }

    public List<Tages> getTagesList() {
        return tagesList;
    }

    public void setTagesList(List<Tages> tagesList) {
        this.tagesList = tagesList;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgurl='" + imgurl + '\'' +
                ", flag='" + flag + '\'' +
                ", count=" + count +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", share=" + share +
                ", pay=" + pay +
                ", comment=" + comment +
                ", copyright=" + copyright +
                ", describes='" + describes + '\'' +
                ", typoid=" + typoid +
                ", user=" + user +
                ", typo=" + typo +
                ", tagesList=" + tagesList +
                '}';
    }
}
