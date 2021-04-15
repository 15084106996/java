package org.neuedu.java20_security02.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.neuedu.java20_security02.model.Menu;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<Menu> getMenuRoles();
}
