package org.neuedu.ch数据库连接JDBC.demo04;

import java.sql.*;

public class Demo04 {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc_java20?useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
            String username = "root";
            String password = "12345678";
            conn = DriverManager.getConnection(url,username,password);
            // 开启事务管理
            conn.setAutoCommit(false);
            String sql = "insert into `user` VALUES (default,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,"华安2");
            statement.setBoolean(2,true);
            statement.setString(3, "1999-9-9");
            statement.setInt(4,21);
            int i = statement.executeUpdate();
            // 手动提交
            conn.commit();
            if (i != 0) {
                System.out.println("新增成功");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }
    }
}
