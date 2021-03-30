package org.neuedu.ch异常处理.practice01;

public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        User user = service.findUserByName("mike1");
        if (user != null) {
            System.out.println(user.getName()+","+user.getAge());
        }
    }
}
