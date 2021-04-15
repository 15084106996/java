package org.neuedu.ch集合.demo10;

import java.util.List;

public interface Mapper {
    User findUserByStuno(int stuno);
    List<User> findUserByName(String name);
}
