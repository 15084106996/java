package org.neuedu.java20_security02.controller;

import org.neuedu.java20_security02.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/hello")
    public String hello1() {
        return "hello1";
    }

    @GetMapping("/admin/hello")
    public String hello2() {
        return "hello admin";
    }

    @GetMapping("/user/hello")
    public String hello3() {
        return "hello user";
    }

    @GetMapping("/bbb/hello")
    public String hello4() {
        return "hello bbb";
    }

    @GetMapping("/login")
    public RespBean hello5() {
        return RespBean.error(500,"请先登录！");
    }

    @GetMapping("/dba/hello")
    public String hello6() {
        return "hello dba";
    }
}
