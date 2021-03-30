package org.neuedu.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库工具类
 *  1.获取数据库连接
 *  2.关闭回收资源
 *  3.单例模式
 */
@Component
public class DBUtils {
    private static DBUtils dbUtils;
    @Value("${mysql.driverClassName}")
    private String driverClassName;
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;

    private DBUtils(){

    }
    public static DBUtils getInstance() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-springmvc.xml");
        if (dbUtils == null) {
            dbUtils = context.getBean("DBUtils", DBUtils.class);
        }
        return dbUtils;
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverClassName);
        return DriverManager.getConnection(url,username,password);
    }

    public void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void close(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}