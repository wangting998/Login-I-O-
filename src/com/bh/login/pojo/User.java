package com.bh.login.pojo;
/**
 * 2021/1/18
 * 用户实体类（封装类,将当前注册的账号密码封装在此类中）
 */
public class User {
    private String username; //用户名
    private String password; //密码

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(){

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
}
