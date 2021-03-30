package org.neuedu.service;
import org.neuedu.bean.RespBean;
import org.neuedu.bean.SysUser;
import org.neuedu.dao.SysUserDao;
import org.neuedu.dao.SysUserDaoImpl;
import org.neuedu.utils.MD5Utils;
import org.neuedu.bean.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {
    @Autowired
    SysUserDao dao;
    public RespBean doLogin(String username, String password) {
        // 密码加密
//        SysUser user = dao.findUserByNameAndPass(username, MD5Utils.Md5(username+password));
        SysUser user = dao.findUserByNameAndPass(username, password);
        if (user == null) {
            return RespBean.error(500, "用户名或密码错误");
        }else{
            // 查询 用户的 角色
            List<Role> roles = dao.getRolesById(user.getId());
            user.setPassword(null);
            user.setRoles(roles);
            return RespBean.success(200, "登录成功",user);
        }
    }
}
