package org.neuedu.java20vblog.mapper;

import org.neuedu.java20vblog.model.Role;
import org.neuedu.java20vblog.model.User;

import java.util.List;

public interface UserMapper {
    User loadUserByUsername(String username);
    List<Role> getRolesById(Long id);
}
