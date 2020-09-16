package com.tcsoft.security.service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.*;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author big_john
 */
@Service
public class UserQueryService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    public ResultData<List<UserServiceBean>> query(Authentication authentication){
        ResultData<List<UserServiceBean>> resultData = new ResultData<>();
        List<UserServiceBean> list;
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        List<UserServiceBean> userList = userMapper.selectUserById(jwtUser.getUserId());
        UserServiceBean serviceBean = userList.get(0);
        if (UserConstant.SYSTEM_GROUP.equals(serviceBean.getGroup())){
            if (UserConstant.SYSTEM_ADMIN.equals(serviceBean.getRole())){
                list = userMapper.selectAllUser();
            }else {
                list = userMapper.selectUserAllGroupId();
            }
        }else {
            list = userMapper.selectSameGroup(serviceBean.getGroup(), jwtUser.getUserId());
        }
        resultData.setMessage("查询成功");
        resultData.setData(list);
        return resultData;
    }

    public ResultData<List<UserServiceBean>> queryByCondition(QueryConditionBean condition,
                                                              Authentication authentication){
        ResultData<List<UserServiceBean>> resultData = new ResultData<>();
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        UserGroupDao jwtGroup = userGroupMapper.selectById(jwtUser);
        if (condition.getUserId() != null){
            //        根据userId查询
            if (condition.getUserId().equals(jwtUser.getUserId())){
                resultData.setData(userMapper.selectUserById(condition.getUserId()));
                resultData.setMessage("查询成功");
                return resultData;
            }
            UserDao userDao = userMapper.selectById(condition.getUserId());
            UserGroupDao userGroupDao = userGroupMapper.selectById(userDao.getGroupId());
            if (UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup())){
                return querySystemUserById(resultData, condition.getUserId());
            }else if (!UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup()) &&
                    UserConstant.SYSTEM_GROUP.equals(jwtGroup.getGroup())){
                return queryAnyHospital(resultData, condition.getUserId());
            }else if (userDao.getGroupId().equals(jwtUser.getGroupId())){
                return querySameHospital(resultData, condition.getUserId());
            }
        }else if (condition.getUsername() != null){
            //        根据username查询
            UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                    .eq("UserName", condition.getUsername()));
            if (userDao.getUserId().equals(jwtUser.getUserId())){
                resultData.setData(userMapper.selectUserById(userDao.getUserId()));
                resultData.setMessage("查询成功");
                return resultData;
            }
            UserGroupDao userGroupDao = userGroupMapper.selectById(userDao.getGroupId());
            if (UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup())){
                return querySystemUserById(resultData, userDao.getUserId());
            }else if (!UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup()) &&
                    UserConstant.SYSTEM_GROUP.equals(jwtGroup.getGroup())){
                return queryAnyHospital(resultData, userDao.getUserId());
            }else if (userDao.getGroupId().equals(jwtUser.getGroupId())){
                return querySameHospital(resultData, userDao.getUserId());
            }
        }else if (condition.getGroup() != null && !"".equals(condition.getGroup())){
            //        根据group查询
            if (UserConstant.SYSTEM_GROUP.equals(condition.getGroup())){
                return querySystemGroup(resultData, condition.getGroup());
            }else if (!UserConstant.SYSTEM_GROUP.equals(condition.getGroup()) &&
                    !condition.getGroup().equals(jwtGroup.getGroup())){
                return queryAnyHospitalGroup(resultData, condition.getGroup());
            }else if (!UserConstant.SYSTEM_GROUP.equals(condition.getGroup()) &&
                    condition.getGroup().equals(jwtGroup.getGroup())){
                return querySameHospitalGroup(resultData, condition.getGroup());
            }
        }
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<List<UserServiceBean>> querySystemUserById(
            ResultData<List<UserServiceBean>> resultData, Integer userId){
        resultData.setData(userMapper.selectUserById(userId));
        return resultData;
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<List<UserServiceBean>> queryAnyHospital(
            ResultData<List<UserServiceBean>> resultData, Integer userId){
        resultData.setData(userMapper.selectUserById(userId));
        return resultData;
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user', 'hospital')")
    private ResultData<List<UserServiceBean>> querySameHospital(
            ResultData<List<UserServiceBean>> resultData, Integer userId){
        resultData.setData(userMapper.selectUserById(userId));
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<List<UserServiceBean>> querySystemGroup(
            ResultData<List<UserServiceBean>> resultData, String group){
        resultData.setData(userMapper.selectUserByGroup(group));
        return resultData;
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<List<UserServiceBean>> queryAnyHospitalGroup(
            ResultData<List<UserServiceBean>> resultData, String group){
        resultData.setData(userMapper.selectUserByGroup(group));
        return resultData;
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user', 'hospital')")
    private ResultData<List<UserServiceBean>> querySameHospitalGroup(
            ResultData<List<UserServiceBean>> resultData, String group){
        resultData.setData(userMapper.selectUserByGroup(group));
        return resultData;
    }

}
