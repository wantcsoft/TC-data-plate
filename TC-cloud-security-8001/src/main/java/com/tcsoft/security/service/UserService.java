package com.tcsoft.security.service;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.FrontUser;
import com.tcsoft.security.entity.ResultData;

/**
 * 用户接口
 * @author big_john
 */
public interface UserService {
    /**
     * 用户注册账号接口
     * @param userToAdd
     * @return
     */
    ResultData register(FrontUser userToAdd);

    /**
     * 用户登录接口
     * @param username
     * @param password
     * @return
     */
    ResultData login(String username, String password);

    /**
     * 用户信息修改
     * @param userToModify
     * @return
     */
    ResultData modify(FrontUser userToModify);

    /**
     * 删除用户信息
     * @param userDelete
     * @return
     */
    ResultData delete(UserDao userDelete);

    /**
     * 获取所有的用户信息
     * @param username
     * @return
     */
    ResultData getAllUser(String username);

    /**
     * 用户刷新token有效期接口
     * @param oldToken
     * @return
     */
    ResultData refresh(String oldToken);

}
