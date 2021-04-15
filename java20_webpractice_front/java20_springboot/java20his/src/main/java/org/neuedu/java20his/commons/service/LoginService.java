package org.neuedu.java20his.commons.service;

import org.neuedu.java20his.commons.mapper.LoginMapper;
import org.neuedu.java20his.systeminfo.model.RespBean;
import org.neuedu.java20his.systeminfo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;
    public RespBean doLogin(User user) {
        User reUser = loginMapper.doLogin(user);
        if (reUser != null) {
            reUser.setPassword(null);
            return RespBean.success(200, "登录成功", reUser);
        }else{
            return RespBean.error(500, "用户登录名或密码有误");
        }
    }
}
