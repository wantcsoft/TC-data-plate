package com.tcsoft.security.service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.*;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author big_john
 */
@Service
public class UserQueryService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGroupMapper userGroupMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    public ResultData<List<UserDao>> query(QueryConditionBean condition,
                                                 Authentication authentication) {
        ResultData<List<UserDao>> resultData = new ResultData<>();
        //根据userId查询用户
        if (condition.getUserId() != null) {
            UserDao userDao = userMapper.selectById(condition.getUserId());
            return handleSingle(userDao, authentication);
            //根据username查询用户
        } else if (condition.getUsername() != null) {
            UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                    .eq("userName", condition.getUsername()));
            return handleSingle(userDao, authentication);
            //根据groupId查询用户
        } else if (condition.getGroupId() != null) {
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            List<UserDao> list = userMapper.selectList(new QueryWrapper<UserDao>()
                    .eq("groupId", condition.getGroupId()));
            if (condition.getGroupId() == UserConstant.SYSTEM_GROUP_ID) {
                return querySystemAdmin(list, resultData);
            } else {
                UserGroupDao userGroupDao = userGroupMapper.selectById(condition.getGroupId());
                if (userGroupDao != null && jwtUser.getGroupId() != UserConstant.SYSTEM_GROUP_ID) {
                    return queryHospital(list, resultData);
                }else {
                    resultData.setCode(401);
                    resultData.setMessage("权限不足");
                    return null;
                }
            }
        } else {
            //查询自己能查的所有用户
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            Integer roleGrade = userRoleMapper.selectById(userMapper.selectById(jwtUser.getUserId()).getRoleId()).getRoleGrade();
            List<Integer> roleIdList = userRoleMapper.selectList(new QueryWrapper<UserRoleDao>()
                    .select("roleId")
                    .lt("roleGrade", roleGrade)).stream()
                        .map(UserRoleDao::getRoleId)
                        .collect(Collectors.toList());
            List<UserDao> list = userMapper.selectList(new QueryWrapper<UserDao>()
                    .select("userId", "groupId", "roleId", "userName", "lastPasswordResetDate", "accountNonLocked", "enabled")
                    .in("roleId", roleIdList));
            resultData.setMessage("查询成功");
            resultData.setData(list);
            return resultData;
        }
    }

    public ResultData<List<UserServiceBean>> frontQuery(Authentication authentication){
        ResultData<List<UserServiceBean>> resultData = new ResultData<>();
        List<UserServiceBean> list;
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        Integer groupId = userMapper.selectById(jwtUser.getUserId()).getGroupId();
        if (UserConstant.SYSTEM_GROUP_ID == groupId){
            Integer roleGrade = userRoleMapper.selectById(userMapper.selectById(jwtUser.getUserId()).getRoleId()).getRoleGrade();
            Map<Integer, String> roleMap = userRoleMapper.selectList(new QueryWrapper<UserRoleDao>()
                    .select("roleId", "roleDescription")
                    .lt("roleGrade", roleGrade))
                    .stream()
                    .collect(Collectors.toMap(UserRoleDao::getRoleId, UserRoleDao::getRoleDescription));
            Map<Integer, String> groupMap = userGroupMapper.selectList(null)
                    .stream()
                    .collect(Collectors.toMap(UserGroupDao::getGroupId, UserGroupDao::getGroupDescription));
            list = userMapper.selectList(new QueryWrapper<UserDao>()
                    .select("userId", "groupId", "roleId", "userName", "lastPasswordResetDate", "accountNonLocked", "enabled")
                    .in("roleId", roleMap.keySet())).stream()
                    .map(userDao -> {
                        UserServiceBean userServiceBean = new UserServiceBean();
                        BeanUtils.copyProperties(userDao, userServiceBean);
                        userServiceBean.setRoleDescription(roleMap.get(userDao.getRoleId()));
                        userServiceBean.setGroupDescription(groupMap.get(userDao.getGroupId()));
                        return userServiceBean;
                    })
                    .collect(Collectors.toList());
        }else {
            String groupDescription = userGroupMapper.selectById(groupId)
                    .getGroupDescription();
            String roleDescription = userRoleMapper.selectById(userMapper.selectById(jwtUser.getUserId()).getRoleId())
                    .getRoleDescription();
            list = userMapper.selectList(new QueryWrapper<UserDao>().eq("groupId", groupId))
                    .stream()
                    .map(userDao -> {
                        UserServiceBean userServiceBean = new UserServiceBean();
                        BeanUtils.copyProperties(userDao, userServiceBean);
                        userServiceBean.setRoleDescription(roleDescription);
                        userServiceBean.setGroupDescription(groupDescription);
                        return userServiceBean;
                    })
                    .collect(Collectors.toList());
        }
        resultData.setMessage("查询成功");
        resultData.setData(list);
        return resultData;
    }

    public ResultData<List<UserServiceBean>> frontQueryByName(String username, Authentication authentication){
        ResultData<List<UserServiceBean>> resultData = new ResultData<>();
        JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
        UserRoleDao user = userRoleMapper.selectById(userMapper.selectById(jwtUser.getUserId())
                .getRoleId());
        UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                .eq("userName", username));
        if (userDao == null){
            resultData.setMessage("没有该用户");
            return resultData;
        }
        UserRoleDao msg = userRoleMapper.selectById(userDao.getRoleId());
        if (user.getRoleGrade() <= msg.getRoleGrade()){
            resultData.setCode(401);
            resultData.setMessage("权限不足");
        }else {
            List<UserServiceBean> list = new ArrayList<>();
            UserServiceBean userServiceBean = new UserServiceBean();
            BeanUtils.copyProperties(userDao, userServiceBean);
            userServiceBean.setGroupDescription(userGroupMapper.selectById(userDao.getGroupId()).getGroupDescription());
            userServiceBean.setRoleDescription(userRoleMapper.selectById(userDao.getRoleId()).getRoleDescription());
            resultData.setMessage("查询成功");
            list.add(userServiceBean);
            resultData.setData(list);
        }
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
