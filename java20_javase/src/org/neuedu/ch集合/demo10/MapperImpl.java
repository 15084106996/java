package org.neuedu.ch集合.demo10;

import java.util.ArrayList;
import java.util.List;

public class MapperImpl implements Mapper {

    @Override
    public User findUserByStuno(int stuno) {
        List<User> list = new ArrayList<>();
        list.add(new User(1001,"tom"));
        list.add(new User(1002,"ella"));
        list.add(new User(1003,"bob"));
        list.add(new User(1004,"tom"));
        list.add(new User(1005,"lucy"));

        for (User user : list) {
            if (user.getStuno() == stuno) {
                return user;
            }
        }

        return null;
    }

    @Override
    public List<User> findUserByName(String name) {
        List<User> list = new ArrayList<>();
        list.add(new User(1001,"tom"));
        list.add(new User(1002,"ella"));
        list.add(new User(1003,"bob"));
        list.add(new User(1004,"tom"));
        list.add(new User(1005,"lucy"));

        List<User> users = new ArrayList<>();
        for (User user : list) {
            if (user.getName().equals(name)) {
                users.add(user);
            }
        }

        return users;
    }
}
