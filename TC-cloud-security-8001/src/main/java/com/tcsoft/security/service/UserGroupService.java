package com.tcsoft.security.service;

import com.tcsoft.security.entity.ResultData;

/**
 * 用户的群组接口
 * @author big_john
 */
public interface UserGroupService {
    /**
     * 根据用户名获取用户可支配的的群组
     * @param username
     * @return
     */
    ResultData getUserGroup(String username);
}
