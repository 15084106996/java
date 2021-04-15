package org.neuedu.java20vblog.controller;

import org.neuedu.java20vblog.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error(500, "用户未登录，请先登录");
    }
}
