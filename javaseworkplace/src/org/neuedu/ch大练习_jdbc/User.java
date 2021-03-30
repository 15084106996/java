package org.neuedu.ch大练习_jdbc;

import java.util.Date;

public class User {
    private Long id;
    private String name;
    private String username;
    private String password;
    private boolean gender;
    private Date birthday;
    private Integer age;
    @Override
    public String toString() {
        return  "User{"+
                "id="+id+','+
                "name="+name+','+
                "username="+username+','+
                "password="+password+','+
                "gender="+gender+','+
                "birthday="+birthday+','+
                "age="+age+',';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
