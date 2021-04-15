package org.neuedu.java20his.commons.controller;

import org.neuedu.java20his.commons.service.LoginService;
import org.neuedu.java20his.systeminfo.model.RespBean;
import org.neuedu.java20his.systeminfo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @PostMapping("/doLogin")
    public RespBean doLogin(@RequestBody User user) {
        return loginService.doLogin(user);
    }
}
