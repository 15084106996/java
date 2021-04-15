package org.neuedu.ch大练习_jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserService {
    public User userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入用户密码:");
        String password = scanner.nextLine();
        // 封装数据
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserMapper userMapper = new UserMapperImpl();
        return userMapper.userLogin(user);
    }

    public int signIn() {
        // 判断是否登录
        if (Test.user == null) {
            return -1;
        }else{
            // 根据uid和签到日期，查询记录
            UserMapper userMapper = new UserMapperImpl();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int counts = userMapper.findSignInfoByIdAndDate(Test.user.getId(),sdf.format(date));
            // 查到
            if (counts != 0) {
                return 500;
            }
            // 没查到 -- 可以签到
            else{
                userMapper.insertSignInfo(Test.user.getId(),date);
                return 200;
            }
        }
    }

    public int signOut() {
        if (Test.user != null) {
            // 判断 是否 签到过
            UserMapper userMapper = new UserMapperImpl();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            int counts = userMapper.findSignInfoByIdAndDate(Test.user.getId(),sdf.format(date));
            if (counts != 0) {
                // 更新
                int num = userMapper.updateSignOutInfo(Test.user.getId(),new Date());
                if (num == 0) {
                    return 201;
                }
                return 200;
            }else{
                return 500;
            }
        }else{
            return -1;
        }
    }

    public void showSignInfo() {
        if (Test.user != null) {
            UserMapper userMapper = new UserMapperImpl();
            List<SignInfo> signInfoByUid = userMapper.getSignInfoByUid(Test.user.getId());
            System.out.println(Test.user.getName()+",打卡记录如下:");
            for (SignInfo signInfo : signInfoByUid) {
                Date signIn = signInfo.getSignIn();
                Date signOut = signInfo.getSignOut();
                System.out.println("签到时间:"+signIn+",签退时间:"+(signOut == null ? "未签退":signOut));
            }
        }else{
            System.out.println("未登录");
        }
    }

    public int updatePassword() {
        if (Test.user != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入新密码");
            String newPassword = scanner.nextLine();
            UserMapper userMapper = new UserMapperImpl();
            userMapper.updatePassword(Test.user.getId(),newPassword);
            Test.user.setPassword(newPassword);
            return 200;
        }else{
            return -1;
        }
    }
}
