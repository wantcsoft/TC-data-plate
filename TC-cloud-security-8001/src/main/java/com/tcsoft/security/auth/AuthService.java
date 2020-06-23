package com.tcsoft.security.auth;


import com.tcsoft.security.user.User;

/**
 * 注册登录接口
 */
public interface AuthService {
    /**
     * 用户注册账号接口
     * @param userToAdd
     * @return
     */
    boolean register(User userToAdd);

    /**
     * 用户登录接口
     * @param username
     * @param password
     * @return
     */
    String login(String username, String password);

    /**
     * 用户刷新token有效期接口
     * @param oldToken
     * @return
     */
    String refresh(String oldToken);

}
