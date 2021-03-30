package org.neuedu.controller;

import org.neuedu.bean.RespBean;
import org.neuedu.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class SysUserController {
    @Autowired
    SysUserService service;
    @PostMapping("/doLogin")
    public RespBean doLogin(String username, String password, HttpSession session) {
        // 调用Service 登录业务
        RespBean respBean = service.doLogin(username,password);
        // 判断是否有登录信息，有的话将登陆者信息存入session
        if (respBean.getData() != null) {
            session.setAttribute("loginUser",respBean.getData());
        }
        return respBean;
    }
}
