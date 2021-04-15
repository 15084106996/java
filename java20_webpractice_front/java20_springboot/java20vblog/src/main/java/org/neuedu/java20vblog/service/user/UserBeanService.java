package org.neuedu.java20vblog.service.user;

import org.neuedu.java20vblog.mapper.UserBeanMapper;
import org.neuedu.java20vblog.model.RespBean;
import org.neuedu.java20vblog.model.Role;
import org.neuedu.java20vblog.model.User;
import org.neuedu.java20vblog.model.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class UserBeanService {
    @Autowired
    UserBeanMapper userBeanMapper;

    public List<UserBean> getUserInfos(String keyWords) {
        return userBeanMapper.getUserInfos(keyWords);
    }

    public RespBean updateEnabled(UserBean userBean) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId().longValue() == userBean.getId().longValue()) {
            return RespBean.error(500, "您正在登录，不能修改个人状态");
        } else {
            int i = userBeanMapper.updateEnabled(userBean);
            if (i == 0) {
                return RespBean.error(500, "启用禁用操作失败");
            } else {
                return RespBean.success(200, "操作成功");
            }
        }
    }

    public RespBean updateLocked(UserBean userBean) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (user.getId().longValue() == userBean.getId().longValue()) {
            return RespBean.error(500, "您正在登录，不能修改个人状态");
        } else {
            int i = userBeanMapper.updateLocked(userBean);
            if (i == 0) {
                return RespBean.error(500, "锁定操作失败");
            } else {
                return RespBean.success(200, "操作成功");
            }
        }
    }

    public RespBean updateUserRoles(UserBean userBean) {
        // 先判断有没有角色id，如果没有角色id，直接响应错误信息
        List<Integer> roleIds = userBean.getRoleIds();
        if (roleIds == null || roleIds.size() == 0) {
            return RespBean.error(500, "角色非法操作，用户必须包含一个角色");
        } else {
            // 先获取 用户原有的 角色信息
            List<Role> roles = userBeanMapper.getUserRoles(userBean.getId());
            // 本次请求 修改 的角色信息
            for (Role role : roles) {
                if (role.getRname().equals("ROLE_admin")) {
                    for (int id : roleIds) {
                        if (id == role.getId().intValue()) {
                            userBeanMapper.deleteUserRole(userBean);
                            userBeanMapper.insertUserRole(userBean);
                            return RespBean.success(200, "修改角色成功");
                        }
                    }
                    return RespBean.error(500, "无法删除超级管理员");
                }
            }
            // 修改的用户原本不是管理员
            userBeanMapper.deleteUserRole(userBean);
            userBeanMapper.insertUserRole(userBean);
            return RespBean.success(200, "修改角色成功");
        }
    }
}
