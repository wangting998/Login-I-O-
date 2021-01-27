package com.bh.login.dao.userdao;

import com.bh.login.pojo.User;

import java.io.IOException;

/**
 * 定义接口（登录方法与注册方法）
 */
public interface UserDao {
    /**
     * 这是用户接口
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回登录是否成功
     */
    public abstract boolean isLogin(String username, String password);

    /**
     * 这是注册接口
     *
     * @param user 需注册的用户信息
     */
    public abstract void regist(User user);
}
