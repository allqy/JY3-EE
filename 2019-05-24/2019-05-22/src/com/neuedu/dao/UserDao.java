package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface UserDao {
    boolean addOneUser(User user);
    List<User> queryAllUser();
    boolean delUserById(Integer uid);
    boolean updateUserById(User user);
    List<User> login(String uname,String upwd);
}
