package com.neuedu.entity;

import java.sql.Date;

public class Product {
    private String pro_id;
    private String pro_name;
    private Double pro_price;
    private String pro_image;
    private String pro_des;
    private Short pro_stock;
    private Date pro_date;
    private Short cate_id;
    private String pro_fac;

    public Product() {

    }

    public Product(String pro_id, String pro_name, Double pro_price, String pro_image, String pro_des, Short pro_stock, Date pro_date, Short cate_id, String pro_fac) {
        this.pro_id = pro_id;
        this.pro_name = pro_name;
        this.pro_price = pro_price;
        this.pro_image = pro_image;
        this.pro_des = pro_des;
        this.pro_stock = pro_stock;
        this.pro_date = pro_date;
        this.cate_id = cate_id;
        this.pro_fac = pro_fac;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pro_id='" + pro_id + '\'' +
                ", pro_name='" + pro_name + '\'' +
                ", pro_price=" + pro_price +
                ", pro_image='" + pro_image + '\'' +
                ", pro_des='" + pro_des + '\'' +
                ", pro_stock=" + pro_stock +
                ", pro_date=" + pro_date +
                ", cate_id=" + cate_id +
                ", pro_fac='" + pro_fac + '\'' +
                '}';
    }

    public String getPro_id() {
        return pro_id;
    }

    public void setPro_id(String pro_id) {
        this.pro_id = pro_id;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Double getPro_price() {
        return pro_price;
    }

    public void setPro_price(Double pro_price) {
        this.pro_price = pro_price;
    }

    public String getPro_image() {
        return pro_image;
    }

    public void setPro_image(String pro_image) {
        this.pro_image = pro_image;
    }

    public String getPro_des() {
        return pro_des;
    }

    public void setPro_des(String pro_des) {
        this.pro_des = pro_des;
    }

    public Short getPro_stock() {
        return pro_stock;
    }

    public void setPro_stock(Short pro_stock) {
        this.pro_stock = pro_stock;
    }

    public Date getPro_date() {
        return pro_date;
    }

    public void setPro_date(Date pro_date) {
        this.pro_date = pro_date;
    }

    public Short getCate_id() {
        return cate_id;
    }

    public void setCate_id(Short cate_id) {
        this.cate_id = cate_id;
    }

    public String getPro_fac() {
        return pro_fac;
    }

    public void setPro_fac(String pro_fac) {
        this.pro_fac = pro_fac;
    }
}
