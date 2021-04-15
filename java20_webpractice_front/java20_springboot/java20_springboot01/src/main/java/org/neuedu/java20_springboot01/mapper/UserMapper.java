package org.neuedu.java20_springboot01.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.neuedu.java20_springboot01.model.User;

import java.util.List;

//@Mapper
public interface UserMapper {
    List<User> getUsers();
}
