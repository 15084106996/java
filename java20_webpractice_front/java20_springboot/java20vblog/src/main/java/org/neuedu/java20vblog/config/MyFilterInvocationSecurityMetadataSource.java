package org.neuedu.java20vblog.config;

import org.neuedu.java20vblog.model.Menu;
import org.neuedu.java20vblog.model.Role;
import org.neuedu.java20vblog.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    // 缓存的权限和角色对应关系，真正的项目一般采取Redis
    List<Menu> menus = null;
    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        // 获取请求地址
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        // 获取 所有 权限和角色的 关系
        if (menus == null) {
            menus = menuService.getMenuRoles();
        }
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getPattern(), requestUrl)) {
                List<Role> roles = menu.getRoles();
                String[] strs = new String[roles.size()];
                int index = 0;
                for (Role role : roles) {
                    strs[index] = role.getRname();
                    index++;
                }
                return SecurityConfig.createList(strs);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
