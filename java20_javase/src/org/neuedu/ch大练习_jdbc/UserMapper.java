package org.neuedu.ch大练习_jdbc;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    // 根据用户名和密码查询用户
    User userLogin(User user);

    // 根据id和签到日期查询
    int findSignInfoByIdAndDate(Long uid,String signIn);

    // 签到
    int insertSignInfo(Long uid, Date signIn);

    // 更新签退日期
    int updateSignOutInfo(Long uid, Date signOut);

    // 查询个人打卡信息
    List<SignInfo> getSignInfoByUid(Long uid);

    // 修改密码
    int updatePassword(Long id, String newPassword);
}
