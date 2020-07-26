package com.tcsoft.security.utils;


import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author big_john
 */
public final class CheckUserToken {

    @Resource
    private static JwtTokenUtil jwtTokenUtil;
    @Resource
    private static UserMapper userMapper;
    @Resource
    private static UserGroupMapper userGroupMapper;

    public static String checkToken(String token){
        Date date = jwtTokenUtil.getCreatedDateFromToken(token);
        if (date == null){
            return "token异常";
        }else {
            if (jwtTokenUtil.isTokenExpired(token)){
                return "token过期";
            }else {
                return "";
            }
        }
    }

    public static String getTokenUserName(String token){
        String username = jwtTokenUtil.getUsernameFromToken(token);
        if (username == null){
            return "";
        }else {
            return username;
        }
    }

    public static boolean checkAuthority(String userName, int userId){
        UserRoleDao userRoleDao1 = userMapper.queryUserRoleByName(userName);
        UserRoleDao userRoleDao2 = userMapper.queryUserRoleById(userId);
        if (userRoleDao1==null || userRoleDao2==null) {
            return false;
        }
        if (userRoleDao1.getRoleGrade() > userRoleDao2.getRoleGrade()){
            return true;
        }else if (userRoleDao1.getRoleGrade().equals(userRoleDao2.getRoleGrade())){
            UserGroupDao userGroupDao1 = userGroupMapper.queryGroupByUserName(userName);
            UserGroupDao userGroupDao2 = userGroupMapper.queryGroupByUserId(userId);
            return userGroupDao1.getGroupId().equals(userGroupDao2.getGroupId()) && userGroupDao2.getGroupId() != 1;
        }else {
            return false;
        }
    }

}
