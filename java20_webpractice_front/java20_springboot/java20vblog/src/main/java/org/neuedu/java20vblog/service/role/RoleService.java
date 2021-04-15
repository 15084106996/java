package org.neuedu.java20vblog.service.role;

import org.neuedu.java20vblog.mapper.RoleMapper;
import org.neuedu.java20vblog.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleService {
    @Autowired
    RoleMapper roleMapper;

    public List<Role> getRoles() {
        return roleMapper.getRoles();
    }
}
