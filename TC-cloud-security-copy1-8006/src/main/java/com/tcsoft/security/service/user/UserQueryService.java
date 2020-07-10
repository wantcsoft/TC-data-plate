package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.QueryUserBean;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserQueryService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    public ResultData<List<QueryUserBean>> queryAllUser(String username, ResultData<List<QueryUserBean>> resultData) {
        List<QueryUserBean> userList;
        UserDao currentUser = userMapper.queryUserByName(username);
        Integer groupId = currentUser.getGroupId();
        Integer roleGrade = userMapper.queryUserRoleGrade(username);
        if (groupId == UserConstant.SYSTEM_GROUP_ID){
            // 系统级用户，可以查看所有医院用户信息,还有比自己等级低的系统用户
            Integer maxGrade = userRoleMapper.queryMaxGrade();
            if (roleGrade.equals(maxGrade)){
                // 这是系统管理员用户，权限最高
                userList = userMapper.systemAdminQueryAllUser();
            }else {
                // 其他系统用户查看比自己等级低的用户
                userList = userMapper.systemQueryAllUser(roleGrade);
            }
        }else {
            // 这是一个医院用户，只能查看本医院的用户
            userList = userMapper.hospitalQueryAllUser(groupId, roleGrade);
        }
        if (userList.size() != 0){
            resultData.setData(userList);
            resultData.setMessage("获取" + userList.size() + "条数据");
        }else {
            resultData.setMessage("获取0条数据");
        }
        return resultData;
    }

    public ResultData<List<QueryUserBean>> queryUserByName(String username, JwtUser user, ResultData<List<QueryUserBean>> resultData){
        UserDao userDao = userMapper.queryUserByName(username);
        if (userDao == null){
            resultData.setMessage("没有找到该用户");
            resultData.setData(new ArrayList<>());
            return resultData;
        }else {
            Integer groupId = userDao.getGroupId();
            Integer roleId = userDao.getRoleId();
            if (groupId == UserConstant.SYSTEM_GROUP_ID){
                if (roleId == UserConstant.SYSTEM_ADMIN_ID){
                    //查询的是系统管理员
                    return querySystemAdminByName(userDao, resultData);
                }else if (roleId == UserConstant.SYSTEM_SUPER_USER_ID){
                    //系统超级用户
                    return querySystemSuperUserByName(userDao, resultData);
                }else if (roleId == UserConstant.SYSTEM_USER_ID){
                    //系统普通用户
                    return querySystemUserByName(userDao, resultData);
                }else {
                    resultData.setMessage("该用户信息有误");
                    resultData.setData(new ArrayList<>());
                    return resultData;
                }
            } else {
                //这是一个医院用户
                if (groupId.equals(user.getGroupId()) || user.getGroupId() == UserConstant.SYSTEM_GROUP_ID){
                    return queryHospitalUserByName(userDao, resultData);
                }else {
                    //不是一个医院
                    resultData.setMessage("没有权限查看该用户");
                    resultData.setData(new ArrayList<>());
                    return resultData;
                }
            }
        }
    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<List<QueryUserBean>> querySystemAdminByName(UserDao userDao, ResultData<List<QueryUserBean>> resultData){
        resultData.setMessage("查询成功");
        resultData.setData(convertQueryUserBean(userDao));
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user')")
    public ResultData<List<QueryUserBean>> querySystemSuperUserByName(UserDao userDao, ResultData<List<QueryUserBean>> resultData){
        resultData.setMessage("查询成功");
        resultData.setData(convertQueryUserBean(userDao));
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user')")
    public ResultData<List<QueryUserBean>> querySystemUserByName(UserDao userDao, ResultData<List<QueryUserBean>> resultData){
        resultData.setMessage("查询成功");
        resultData.setData(convertQueryUserBean(userDao));
        return resultData;
    }

    public ResultData<List<QueryUserBean>> queryHospitalUserByName(UserDao userDao, ResultData<List<QueryUserBean>> resultData){
        resultData.setMessage("查询成功");
        resultData.setData(convertQueryUserBean(userDao));
        return resultData;
    }

    /**
     * 将UserDao 转换为 QueryUserBean
     * @param userDao
     * @return
     */
    public List<QueryUserBean> convertQueryUserBean(UserDao userDao){
        List<QueryUserBean> list = new ArrayList<>();
        QueryUserBean queryUserBean = new QueryUserBean();
        queryUserBean.setUserId(userDao.getUserId());
        queryUserBean.setGroupDescription(userGroupMapper.queryGroupById(userDao.getGroupId()).get(0).getGroupDescription());
        queryUserBean.setRoleDescription(userRoleMapper.queryRoleByName(userDao.getUsername()).getRoleDescription());
        queryUserBean.setUsername(userDao.getUsername());
        queryUserBean.setLastPasswordResetDate(userDao.getLastPasswordResetDate());
        queryUserBean.setAccountNonLocked(userDao.isAccountNonLocked());
        queryUserBean.setEnabled(userDao.isEnabled());
        list.add(queryUserBean);
        return list;
    }

}
