package org.neuedu.ch大练习_jdbc;

import java.util.Date;
import java.util.List;


public interface UserMapper {
    //根据用户名和密码查询用户
    public User userLogin(User user);
    //根据id和签到日期查询
   public int findSignInfoByIdAndDate(Long uid,String signIn);
   //签到
   public int insertSignInfo(Long uid, Date signIn);
   //更新签退日期
   public int updateSignOutInfo(Long uid,Date signOut);
    // 查询个人打卡信息
    public List<SignInfo> getSignInfoByUid(Long uid);
    //修改密码
    public int updateSignInfo(Long id,String password);
    // 根据id删除用户
    public int deleteUserById(Long id);
}