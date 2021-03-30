package org.neuedu.ch数据库连接JDBC.demo02;

import java.sql.*;

public class Demo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc_java20?useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
            String username = "root";
            String password = "12345678";
            conn = DriverManager.getConnection(url,username,password);
            // 用 占位符 代替 真实的数据
            // 1.增加查询效率
            // 2.防止SQL注入
            String sql = "select * from user where age > ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1,25);
            rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                boolean gender = rs.getBoolean("gender");
                String birthday = rs.getString("birthday");
                int age = rs.getInt("age");
                System.out.println(id+","+name+","+gender+","+birthday+","+age);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 将数据库连接，语句，结果集 关闭
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
