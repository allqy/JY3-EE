package com.neuedu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class ConnectionPool {
    private static Properties p=new Properties();
    //设计连接池为单例模式
    private static ConnectionPool connPool;
    private ConnectionPool(){

    }
    public static ConnectionPool getConnectionPool(){
        if(null!=connPool){
            return connPool;
        }
        return new ConnectionPool();
    }

    //通过连接池获取Connection对象
    public Connection getConnection(){
        try {
            p.load(ConnectionPool.class.getResourceAsStream("/dataSource.properties"));
            DataSource ds=DruidDataSourceFactory.createDataSource(p);
            Connection connection=ds.getConnection();
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
