package com.tcsoft.security.service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.*;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserQueryService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    public ResultData<List<UserDao>> query(UserServiceBean userServiceBean,
                                                 Authentication authentication) {
        QueryConditionBean condition = userServiceBean.getCondition();
        ResultData<List<UserDao>> resultData = new ResultData<>();
        if (condition == null){
            resultData.setCode(401);
            resultData.setMessage("查询条件缺失");
            return resultData;
        }else {
            //根据userId查询用户
            if (condition.getUserId() != null){
                UserDao userDao = userMapper.selectById(condition.getUserId());
                return handleSingle(userDao, authentication);
            //根据username查询用户
            }else if (condition.getUsername() != null){
                UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                        .eq("user_name", condition.getUsername()));
                return handleSingle(userDao, authentication);
            //根据groupId查询用户
            }else if (condition.getGroupId() != null){
                JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
                List<UserDao> list = userMapper.selectList(new QueryWrapper<UserDao>()
                        .eq("group_id", condition.getGroupId()));
                if (condition.getGroupId()==UserConstant.SYSTEM_GROUP_ID){
                    return querySystemAdmin(list, resultData);
                }else {
                    UserGroupDao userGroupDao = userGroupMapper.selectById(condition.getGroupId());
                    if (userGroupDao != null && jwtUser.getGroupId()==UserConstant.SYSTEM_GROUP_ID){
                        return queryHospital(list, resultData);
                    }
                }
            }
        }
        resultData.setCode(401);
        resultData.setMessage("查询失败");
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<List<UserDao>> querySystemAdmin(List<UserDao> list, ResultData<List<UserDao>> resultData){
        resultData.setData(list);
        return resultData;
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<List<UserDao>> queryDeveloper(List<UserDao> list, ResultData<List<UserDao>> resultData){
        resultData.setData(list);
        return resultData;
    }

    private ResultData<List<UserDao>> queryHospital(List<UserDao> list, ResultData<List<UserDao>> resultData){
        resultData.setData(list);
        return resultData;
    }

    private ResultData<List<UserDao>> handleSingle(UserDao userDao, Authentication authentication){
        ResultData<List<UserDao>> resultData = new ResultData<>();
        if (userDao != null){
            resultData.setCode(200);
            resultData.setMessage("查询成功");
            userDao.setPassword("");
            List<UserDao> list = new ArrayList<>();
            if (userDao.getRoleId()==UserConstant.SYSTEM_ADMIN_ID ||
                    userDao.getRoleId()==UserConstant.SYSTEM_USER_ID){
                list.add(userDao);
                return querySystemAdmin(list, resultData);
            }else if (userDao.getRoleId()==UserConstant.DEVELOPER_ID){
                list.add(userDao);
                return queryDeveloper(list, resultData);
            }else if (userDao.getRoleId()==UserConstant.HOSPITAL_ID){
                JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
                if (jwtUser.getGroupId() == UserConstant.SYSTEM_GROUP_ID){
                    list.add(userDao);
                    return queryHospital(list, resultData);
                }else if (userDao.getGroupId().equals(jwtUser.getGroupId())){
                    list.add(userDao);
                    return queryHospital(list, resultData);
                }
            }
        }else {
            resultData.setCode(401);
            resultData.setMessage("查询失败");
        }
        return resultData;
    }

}
