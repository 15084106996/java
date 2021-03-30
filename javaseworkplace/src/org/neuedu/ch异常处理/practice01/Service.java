package org.neuedu.ch异常处理.practice01;

public class Service {
    public User findUserByName(String name) {
        User u1 = new User("tom",12);
        User u2 = new User("bob",13);
        User u3 = new User("allen",14);
        User u4 = new User("ella",15);
        User u5 = new User("lucy",16);
        User u6 = new User("mike",17);
        User u7 = new User("smith",18);
        User[] users = {u1, u2, u3, u4, u5, u6, u7};
        for (User user : users) {
            if (user.getName() == name) {
                return user;
            }
        }
        try {
            throw new UserNotFoundException();
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
