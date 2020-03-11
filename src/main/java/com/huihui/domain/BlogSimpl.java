package com.huihui.domain;

public class BlogSimpl {
   private String title ;
   private Integer typoid ;
   private Boolean put  ;

   public BlogSimpl(Boolean put) {
      this.put = put;
   }

   public BlogSimpl(String title, Boolean put) {
      this.title = title;
      this.put = put ;
   }

   public BlogSimpl(Integer typoid, Boolean put) {
      this.typoid = typoid;
      this.put = put;
   }

   public BlogSimpl() {
   }

   public BlogSimpl(String title, Integer typoid, Boolean put) {
      this.title = title;
      this.typoid = typoid;
      this.put = put;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Integer getTypoid() {
      return typoid;
   }

   public void setTypoid(Integer typoid) {
      this.typoid = typoid;
   }

   public Boolean getPut() {
      return put;
   }

   public void setPut(Boolean put) {
      this.put = put;
   }

   @Override
   public String toString() {
      return "BlogSimpl{" +
              "title='" + title + '\'' +
              ", typoid=" + typoid +
              ", put=" + put +
              '}';
   }
}
