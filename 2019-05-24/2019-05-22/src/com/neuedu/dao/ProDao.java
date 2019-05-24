package com.neuedu.dao;

import com.neuedu.entity.Product;

import java.util.List;

public interface ProDao {
    //添加商品
    boolean addOnePro(Product product);
    //查询所有商品信息
    List<Product> queryAllPro();
}
