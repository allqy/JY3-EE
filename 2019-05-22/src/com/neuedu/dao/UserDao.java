package com.neuedu.dao;

import com.neuedu.entity.User;

import java.util.List;

public interface UserDao {
    List<User> queryAllUser();
    boolean delUserByName(String uname);
    boolean updateUserByName(String uname,Object...objs);
}
