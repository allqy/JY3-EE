package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface UserDao {
    List<User> selectByName(String uName);
    boolean addOneUser(User user);
    List<User> login(User user);
}
