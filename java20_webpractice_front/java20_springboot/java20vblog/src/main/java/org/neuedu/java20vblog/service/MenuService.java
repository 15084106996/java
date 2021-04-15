package org.neuedu.java20vblog.service;

import org.neuedu.java20vblog.mapper.MenuMapper;
import org.neuedu.java20vblog.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getMenuRoles() {
        return menuMapper.getMenuRoles();
    }
}
