package org.neuedu.ch数据库连接JDBC.demo01;

import java.sql.*;
import java.util.Date;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1.加载 数据库 启动(将 数据库驱动类 加载进 JVM 内存)
        // 5.x com.mysql.jdbc.Driver  数据参数 useSSL=true&characterEncoding=utf-8&useUnicode=true
        // 8.x com.mysql.cj.jdbc.Driver        useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true
        Class.forName("com.mysql.jdbc.Driver");
        // 2.利用 驱动管理器 获取数据库连接
        // String url       数据库连接地址   主协议:次协议://主机IP:端口号/数据库名称?数据库参数
        // String username  数据库用户       root
        // String password  用户密码         root
        String url = "jdbc:mysql://localhost:3306/jdbc_java20?useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
        String username = "root";
        String password = "12345678";
        Connection conn = DriverManager.getConnection(url,username,password);
        // 3.获取sql语句对象
        String sql = "select * from user";
        PreparedStatement statement = conn.prepareStatement(sql);
        // 4.执行语句,获取结果集对象
        ResultSet rs = statement.executeQuery();
        // 5.遍历结果集
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            boolean gender = rs.getBoolean("gender");
//            Date birthday = rs.getDate("birthday");
            String birthday = rs.getString("birthday");
            int age = rs.getInt("age");
            System.out.println(id+","+name+","+gender+","+birthday+","+age);
        }
    }
}
