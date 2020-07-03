package com.tcsoft.security.service;

import com.tcsoft.security.entity.ResultData;

/**
 * @author big_john
 */
public interface UserAuthorityService {

    /**
     * 获取自己权限之下的权限
     * @param username
     * @return
     */
    ResultData getUserAuthority(String username);
}
