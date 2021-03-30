package org.neuedu.ch大练习_jdbc;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserService {
    public User userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UserMapper userMapper = new UserMapperImpl();
        return userMapper.userLogin(user);
    }

    public int signIn() {
        if (Test.user == null) {
            return -1;
        } else {
            //根据uid和签到日期查询记录
            UserMapper userMapper = new UserMapperImpl();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            int counts = userMapper.findSignInfoByIdAndDate(Test.user.getId(), sdf.format(date));
            //查到
            if (counts != 0) {
                return 500;
            } else {
                userMapper.insertSignInfo(Test.user.getId(),date);
                return 200;
            }
        }
    }
    public int signOut() {
        if(Test.user!=null){
            //判断是否签过到
            UserMapper userMapper = new UserMapperImpl();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
            int counts = userMapper.findSignInfoByIdAndDate(Test.user.getId(), sdf.format(date));
            if(counts!=0){
                //更新
                int num=userMapper.updateSignOutInfo(Test.user.getId(),new Date());
                return 200;
            }else {
                return 500;
            }
        }else{
            return -1;
        }
    }
    public int showSignInfo(){
        if (Test.user==null){
            return -1;
        }else {
            UserMapper userMapper = new UserMapperImpl();
            List<SignInfo> list=userMapper.getSignInfoByUid(Test.user.getId());
            System.out.println(Test.user.getName()+"打卡记录入下");
            for(SignInfo signInfo:list){
                System.out.println("签到信息:"+signInfo.getSignIn()+"签退信息:"+(signInfo.getSignOut()==null?"未签退":signInfo.getSignOut()));
            }
            return 200;
        }
    }
    public int updateSignInfo(){
        if(Test.user==null){
            return -1;
        }
        else {
            System.out.println("请输入新密码");
            Scanner scanner=new Scanner(System.in);
            String password=scanner.nextLine();
            UserMapper userMapper=new UserMapperImpl();
            int count=userMapper.updateSignInfo(Test.user.getId(),password);
            if(count==0){
                System.out.println("密码修改失败");
            }else {
                System.out.println("密码修改成功");
                Test.user.setPassword(password);
            }
            return count;
        }
    }
    public int deleteUserById(){
        if(Test.user==null){
            return -1;
        }
        else {
            System.out.println("请输入删除的id号");
            Scanner scanner=new Scanner(System.in);
            Long id=scanner.nextLong();
            UserMapper userMapper=new UserMapperImpl();
            int count=userMapper.deleteUserById(id);
            if(count==0){
                System.out.println("删除失败");
            }else {
                System.out.println("删除成功");
            }
            return count;
        }
    }
}
