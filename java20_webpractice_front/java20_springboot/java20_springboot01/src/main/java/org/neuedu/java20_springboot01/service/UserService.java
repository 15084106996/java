package org.neuedu.java20_springboot01.service;

import org.neuedu.java20_springboot01.mapper.UserMapper;
import org.neuedu.java20_springboot01.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
