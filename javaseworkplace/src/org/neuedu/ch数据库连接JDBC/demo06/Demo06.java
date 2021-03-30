package org.neuedu.ch数据库连接JDBC.demo06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo06 {
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
            String sql = "delete from user where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1,10);
            int i = statement.executeUpdate();
            System.out.println(i);
            // 手动提交
            conn.commit();
            if (i != 0) {
                System.out.println("删除成功");
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
