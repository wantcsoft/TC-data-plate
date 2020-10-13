package com.tcsoft.security.service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.*;
import com.tcsoft.security.enums.ResultCode;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * 用户查询业务逻辑
 * @author big_john
 */
@Service
public class UserQueryService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    /**
     * 查询自己所管理的所有用户
     * @param authentication
     * @return
     */
    public ResultData<List<UserServiceBean>> query(Authentication authentication){
        ResultData<List<UserServiceBean>> resultData = new ResultData<>();
        List<UserServiceBean> list;
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        List<UserServiceBean> userList = userMapper.selectUserById(jwtUser.getUserId());
        if (userList.size() == 0) {
            return null;
        }
        UserServiceBean serviceBean = userList.get(0);
        if (UserConstant.SYSTEM_GROUP.equals(serviceBean.getGroup())){
            if (UserConstant.SYSTEM_ADMIN.equals(serviceBean.getRole())){
                list = userMapper.selectAllUsers();
            }else {
                list = userMapper.selectUserAllGroupId();
            }
        }else {
            list = userMapper.selectSameGroup(serviceBean.getGroup(), jwtUser.getUserId());
        }
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(list);
        return resultData;
    }

    /**
     * 根据输入的条件查询用户信息
     * @param condition
     * @param authentication
     * @return
     */
    public ResultData<List<UserServiceBean>> queryByCondition(QueryConditionBean condition,
                                                              Authentication authentication){
        ResultData<List<UserServiceBean>> resultData = new ResultData<>();
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        UserGroupDao jwtGroup = userGroupMapper.selectById(jwtUser);
        if (condition.getUserId() != null){
            //        根据userId查询
            if (condition.getUserId().equals(jwtUser.getUserId())){
                resultData.setData(userMapper.selectUserById(condition.getUserId()));
                resultData.setResultCode(ResultCode.SUCCESS);
                return resultData;
            }
            UserDao userDao = userMapper.selectById(condition.getUserId());
            UserGroupDao userGroupDao = userGroupMapper.selectById(userDao.getGroupId());
            if (UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup())){
                return querySystemUserById(resultData, condition.getUserId());
            }else if (!UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup()) &&
                    UserConstant.SYSTEM_GROUP.equals(jwtGroup.getGroup())){
                return queryAnyHospitalById(resultData, condition.getUserId());
            }else if (userDao.getGroupId().equals(jwtUser.getGroupId())){
                return querySameHospitalById(resultData, condition.getUserId());
            }
        }else if (condition.getUsername() != null){
            //        根据username查询
            UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                    .eq("UserName", condition.getUsername()));
            if (userDao.getUserId().equals(jwtUser.getUserId())){
                resultData.setData(userMapper.selectUserById(userDao.getUserId()));
                resultData.setResultCode(ResultCode.SUCCESS);
                return resultData;
            }
            UserGroupDao userGroupDao = userGroupMapper.selectById(userDao.getGroupId());
            if (UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup())){
                return querySystemUserById(resultData, userDao.getUserId());
            }else if (!UserConstant.SYSTEM_GROUP.equals(userGroupDao.getGroup()) &&
                    UserConstant.SYSTEM_GROUP.equals(jwtGroup.getGroup())){
                return queryAnyHospitalById(resultData, userDao.getUserId());
            }else if (userDao.getGroupId().equals(jwtUser.getGroupId())){
                return querySameHospitalById(resultData, userDao.getUserId());
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

    /**
     * 根据用户ID查询系统用户，只有系统管理员可以
     * @param resultData
     * @param userId
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    private ResultData<List<UserServiceBean>> querySystemUserById(
            ResultData<List<UserServiceBean>> resultData, Integer userId){
        resultData.setData(userMapper.selectUserById(userId));
        return resultData;
    }

    /**
     * 根据用户ID查询任意医院用户
     * @param resultData
     * @param userId
     * @return
     */
    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<List<UserServiceBean>> queryAnyHospitalById(
            ResultData<List<UserServiceBean>> resultData, Integer userId){
        resultData.setData(userMapper.selectUserById(userId));
        return resultData;
    }

    /**
     * 根据用户ID查询同一家医院的用户
     * @param resultData
     * @param userId
     * @return
     */
    @PreAuthorize("hasAnyRole('system_admin', 'system_user', 'hospital')")
    private ResultData<List<UserServiceBean>> querySameHospitalById(
            ResultData<List<UserServiceBean>> resultData, Integer userId){
        resultData.setData(userMapper.selectUserById(userId));
        return resultData;
    }

    /**
     * 根据组信息查询系统组所有的用户
     * @param resultData
     * @param group
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    private ResultData<List<UserServiceBean>> querySystemGroup(
            ResultData<List<UserServiceBean>> resultData, String group){
        resultData.setData(userMapper.selectUserByGroup(group));
        return resultData;
    }

    /**
     * 查询任意医院组的所有成员信息
     * @param resultData
     * @param group
     * @return
     */
    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<List<UserServiceBean>> queryAnyHospitalGroup(
            ResultData<List<UserServiceBean>> resultData, String group){
        resultData.setData(userMapper.selectUserByGroup(group));
        return resultData;
    }

    /**
     * 查询同一家医院组的所有成员信息
     * @param resultData
     * @param group
     * @return
     */
    @PreAuthorize("hasAnyRole('system_admin', 'system_user', 'hospital')")
    private ResultData<List<UserServiceBean>> querySameHospitalGroup(
            ResultData<List<UserServiceBean>> resultData, String group){
        resultData.setData(userMapper.selectUserByGroup(group));
        return resultData;
    }

}
