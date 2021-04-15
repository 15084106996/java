package org.neuedu.java20_security02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.neuedu.java20_security02.model.Role;
import org.neuedu.java20_security02.model.User;

import java.util.List;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    User loadUserByUsername(String username);
    // 根据用户id查询角色
    List<Role> getRolesById(Long id);
}
