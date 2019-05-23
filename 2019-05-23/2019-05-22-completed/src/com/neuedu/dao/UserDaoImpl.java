package com.neuedu.dao;

import com.neuedu.entity.User;
import com.neuedu.utils.ConnectionPool;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao{
    QueryRunner queryRunner;
    //通过连接池获取Connection对象
    ConnectionPool connPool= ConnectionPool.getConnectionPool();
    public UserDaoImpl(){
        queryRunner=new QueryRunner();
    }

    @Override
    public boolean addOneUser(User user) {
        boolean result=false;
        Connection connection=connPool.getConnection();
        String sql="insert into user(uname,upwd) values(?,?)";
        try {
            int i=queryRunner.update(connection,sql,user.getUname(),user.getUpwd());
            if(i>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    //查询所有用户
    public List<User> queryAllUser() {
        List<User> userlist=null;
        String sql="select * from user";
        Connection connection=connPool.getConnection();
        try {
            userlist=queryRunner.query(connection,sql,new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userlist;
    }

    @Override
    public boolean delUserById(Integer uid) {
        boolean result=false;
        Connection connection=connPool.getConnection();
        String sql="delete from user where id=?";
        try {
            int i=queryRunner.update(connection,sql,uid);
            if(i>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    //根据用户名修改密码
    public boolean updateUserById(User user) {
        boolean result=false;
        Connection connection=connPool.getConnection();
        String sql="update user set uname=?,upwd=? where id=?";
        try {
            int i=queryRunner.update(connection,sql,user.getUname(),user.getUpwd(),user.getId());
            if(i>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<User> login(String uname, String upwd) {
        List<User> userlist=null;
        Connection connection=connPool.getConnection();
        String sql="select * from user where uname=? and upwd=?";
        try {
            userlist=queryRunner.query(connection, sql, new BeanListHandler<>(User.class),uname,upwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userlist;
    }
}
