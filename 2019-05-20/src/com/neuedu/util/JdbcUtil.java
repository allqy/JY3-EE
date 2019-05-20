package com.neuedu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static Properties p;
    //获取连接池对象
    public static ConnectionPool connectionPool=ConnectionPool.getConnectionPool();
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //通过连接池获取Connection对象
    public static Connection getConn(){
        return connectionPool.getConn();
    }

    public static PreparedStatement getPrepareStatement(Connection conn,String sql){
        try {
            return conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //为PreparedStatement对象未知参数赋值
    public static void paramToPstm(PreparedStatement pstm,Object ...objects){
        if(objects.length>0){
            for (int i=0;i<objects.length;i++){
                try {
                    pstm.setObject(i+1,objects[i]);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    //关流
    public static void close(Object ...objects){
        if (null!=objects){
            for (Object obj:objects){
                if (obj instanceof Connection){
                    try {
                        ((Connection) obj).close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (obj instanceof PreparedStatement){
                    try {
                        ((PreparedStatement) obj).close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                if (obj instanceof ResultSet){
                    try {
                        ((ResultSet) obj).close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
