package com.spring.transaction;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 功能说明:    <br>
 * 系统版本: 2.0 <br>
 * 开发人员: zhangdl <br>
 * 开发时间:2018/5/21 20:21<br>
 * <br>
 */
public class DatabaseHelper {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql//localhost:3306/test";
    private static final String username = "root";
    private static final String password = "";

    public static void insertEntity(){
    }

    private static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    // 获取连接
    public static Connection getConnection(){
        Connection conn = connectionThreadLocal.get();
        try {
            if(conn == null){
                Class.forName(driver);
                conn = DriverManager.getConnection(url,username,password);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connectionThreadLocal.set(conn);
        }
        return conn;
    }

    public static void beginTransaction(){
        Connection connection = getConnection();
        if(connection != null){
            try {
                connection.setAutoCommit(false);
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {

            }
        }
    }

    /**
     * 提交事务
     */
    public static void commitTransaction(){
        Connection connection = getConnection();
        if(connection != null){
            try {
                connection.commit();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {

            }
        }
    }

    /**
     * 回滚事务
     */
    public static void rollbackTransaction(){
        Connection connection = getConnection();
        if(connection != null){
            try {
                connection.rollback();
                connection.close();
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException(e);
            }finally {

            }
        }
    }
}
