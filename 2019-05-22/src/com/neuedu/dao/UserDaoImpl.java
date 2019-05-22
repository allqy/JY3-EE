package com.neuedu.dao;

import com.neuedu.entity.User;
import com.neuedu.utils.ConnectionPool;
import org.apache.commons.dbutils.QueryRunner;
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
    public boolean delUserByName(String uname) {
        boolean result=false;
        Connection connection=connPool.getConnection();
        String sql="delete from user where uname=?";
        try {
            int i=queryRunner.update(connection,sql,uname);
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
    public boolean updateUserByName(String uname,Object...objs) {
        boolean result=false;
        Connection connection=connPool.getConnection();
        String sql="update user set upwd=? where uname=?";
        try {
            int i=queryRunner.update(connection,sql,objs[0],uname);
            if(i>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
