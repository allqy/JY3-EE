package com.neuedu.entity;

public class User {
    private String uName;
    private String uPwd;

    public User() {

    }

    public User(String uName, String uPwd) {
        this.uName = uName;
        this.uPwd = uPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uName='" + uName + '\'' +
                ", uPwd='" + uPwd + '\'' +
                '}';
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }
}
