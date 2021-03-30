package org.neuedu.ch数据库连接JDBC.demo03;

import java.sql.*;

public class Demo03 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/jdbc_java20?useSSL=false&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true";
            String username = "root";
            String password = "12345678";
            Connection conn = DriverManager.getConnection(url,username,password);
            // 用 占位符 代替 真实的数据
            // 1.增加查询效率
            // 2.防止SQL注入
            String sql = "select * from user where name like concat('%',?,'%')";
            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1,"%艾%");
            statement.setString(1,"艾");
            ResultSet rs = statement.executeQuery();
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
        }
    }
}
