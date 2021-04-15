package org.neuedu.ch集合.demo10;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        // 根据学号查找
        User user = service.getUserByStuno(1001);
        System.out.println(user);
        // 根据姓名查找
        List<User> users = service.getUserByName("bob");
        System.out.println(users);
    }
}
