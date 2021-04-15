package org.neuedu.java20his.commons.mapper;

import org.neuedu.java20his.systeminfo.model.User;

public interface LoginMapper {
    User doLogin(User user);
}
