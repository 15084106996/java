package org.neuedu.java20_security02.service;

import org.neuedu.java20_security02.mapper.MenuMapper;
import org.neuedu.java20_security02.model.Menu;
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
