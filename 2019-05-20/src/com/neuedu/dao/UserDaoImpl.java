package com.neuedu.dao;

import com.neuedu.entity.User;
import com.neuedu.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao{

    @Override
    public List<User> selectByName(String uName) {
        List<User> userlist=new ArrayList<>();
        Connection conn= JdbcUtil.getConn();
        String sql="SELECT * FROM user WHERE uname=?";
        PreparedStatement pstm=JdbcUtil.getPrepareStatement(conn,sql);
        JdbcUtil.paramToPstm(pstm,uName);
        ResultSet rs=null;
        try {
            rs=pstm.executeQuery();
            while (rs.next()){
                User user=new User(rs.getString("uname"),rs.getString("upwd"));
                userlist.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(rs,pstm,conn);
        return userlist;
    }

    @Override
    public boolean addOneUser(User user) {
        boolean result=false;
        Connection conn= JdbcUtil.getConn();
        String sql="INSERT INTO user VALUES(?,?)";
        PreparedStatement pstm=JdbcUtil.getPrepareStatement(conn,sql);
        JdbcUtil.paramToPstm(pstm,user.getuName(),user.getuPwd());
        try {
            int n=pstm.executeUpdate();
            if(n>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(pstm,conn);
        return result;
    }

    @Override
    public List<User> login(User user) {
        List<User> list=new ArrayList<>();
        Connection conn=null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            conn=JdbcUtil.getConn();
            String sql="select * from user where uname=?and upwd=?";
            pstm=conn.prepareStatement(sql);
            JdbcUtil.paramToPstm(pstm,user.getuName(),user.getuPwd());
            rs=pstm.executeQuery();
            while(rs.next()){
                User user1=new User();
                user.setuName(rs.getString("uname"));
                user.setuPwd(rs.getString("upwd"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        JdbcUtil.close(rs,pstm,conn);
        return list;
    }
}
