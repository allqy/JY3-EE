package com.neuedu;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;
import com.neuedu.entity.User;
import com.neuedu.util.JdbcUtil;

import java.sql.Connection;
public class Test {
    public static void main(String[] args) {
        Connection conn= JdbcUtil.getConn();
        System.out.println(conn);
    }
}
