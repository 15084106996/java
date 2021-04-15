package org.neuedu.java20vblog.controller.user;

import org.neuedu.java20vblog.model.RespBean;
import org.neuedu.java20vblog.model.UserBean;
import org.neuedu.java20vblog.service.user.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserBeanService userBeanService;
    @GetMapping("/")
    public List<UserBean> getUserInfos(String keyWords) {
        return userBeanService.getUserInfos(keyWords);
    }

    @PutMapping("/updateEnabled")
    public RespBean updateEnabled(@RequestBody UserBean userBean) {
        return userBeanService.updateEnabled(userBean);
    }

    @PutMapping("/updateLocked")
    public RespBean updateLocked(@RequestBody UserBean userBean) {
        return userBeanService.updateLocked(userBean);
    }

    @PutMapping("/updateUserRoles")
    public RespBean updateUserRoles(@RequestBody UserBean userBean) {
        return userBeanService.updateUserRoles(userBean);
    }
}
