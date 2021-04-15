package org.neuedu.java20vblog.mapper;

import org.neuedu.java20vblog.model.Role;
import org.neuedu.java20vblog.model.UserBean;

import java.util.List;

public interface UserBeanMapper {
    List<UserBean> getUserInfos(String keyWords);

    int updateEnabled(UserBean userBean);

    int updateLocked(UserBean userBean);
    // 根据 用户 id 查询出 所有 角色
    List<Role> getUserRoles(Long id);
    // 删除 用户的 所有 角色
    int deleteUserRole(UserBean userBean);
    // 新增 用户 角色
    int insertUserRole(UserBean userBean);
}
