package com.neuedu.dao;

import com.neuedu.entity.Product;
import com.neuedu.utils.ConnectionPool;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProDaoImpl implements ProDao{
    ConnectionPool connectionPool;
    QueryRunner queryRunner;
    public ProDaoImpl(){
        connectionPool=ConnectionPool.getConnectionPool();
        queryRunner=new QueryRunner();
    }
    @Override
    public boolean addOnePro(Product product) {
        boolean result=false;
        Connection connection=connectionPool.getConnection();
        String sql="INSERT INTO product VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            int i=queryRunner.update(connection,sql,product.getPro_id(),product.getPro_name(),product.getPro_price(), product.getPro_image(),
                    product.getPro_des(),product.getPro_stock(),product.getPro_date(),product.getCate_id(),product.getPro_fac());
            if(i>0){
                result=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public List<Product> queryAllPro() {
        List<Product> prolist=null;
        Connection connection=connectionPool.getConnection();
        String sql="SELECT * FROM product";
        try {
            prolist=queryRunner.query(connection,sql,new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return prolist;
    }
}
