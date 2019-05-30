package com.neuedu.entity;

public class Comment {
    private String uname;
    private String comments;

    public Comment() {
    }

    public Comment(String uname, String comments) {
        this.uname = uname;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "uname='" + uname + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
