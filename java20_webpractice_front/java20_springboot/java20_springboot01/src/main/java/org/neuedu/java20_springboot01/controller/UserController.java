package org.neuedu.java20_springboot01.controller;

import org.neuedu.java20_springboot01.model.User;
import org.neuedu.java20_springboot01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping("/getUsers")
    public List<User> getUsers() {
        return service.getUsers();
    }
}
