package com.neuedu.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//连接池获取Connection对象
public class ConnectionPool {
    //懒汉式单例
    private  static ConnectionPool connectionPool;
    private ConnectionPool(){

    }
    private static Properties p;
    static {
       p=new Properties();
       InputStream is=ConnectionPool.class.getResourceAsStream("/dataSource.properties");
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static DataSource dataSource;
    {
        try {
            dataSource = DruidDataSourceFactory.createDataSource(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConn(){
        Connection conn=null;
        try {
            conn=dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //提供公有的创建对象方法
    public static ConnectionPool getConnectionPool(){
        if(null!=connectionPool){
            return connectionPool;
        }
        return new ConnectionPool();
    }
}
