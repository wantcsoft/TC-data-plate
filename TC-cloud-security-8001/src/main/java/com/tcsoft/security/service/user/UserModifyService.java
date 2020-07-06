package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.ModifyUserBean;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author big_john
 */
@Service
public class UserModifyService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    /**
     * 用户信息修改的具体方法
     * @param modifyUser
     * @param resultData
     * @return
     */
    public ResultData<UserDao> modify(ModifyUserBean modifyUser, ResultData<UserDao> resultData, int roleId){
        if (userMapper.querySameUserName(modifyUser.getUserId(), modifyUser.getUsername()) != null){
            resultData.setMessage("用户名已存在");
            return resultData;
        } else {
            UserDao userDao = new UserDao();
            userDao.setUserId(modifyUser.getUserId());
            userDao.setGroupId(userGroupMapper.queryGroupByDescription(modifyUser.getGroupDescription()).getGroupId());
            userDao.setRoleId(roleId);
            userDao.setUsername(modifyUser.getUsername());
            userDao.setAccountNonLocked(modifyUser.isAccountNonLocked());
            userDao.setEnabled(modifyUser.isEnabled());

            System.out.println(modifyUser.getPassword());
            if (modifyUser.getPassword() == null || "".equals(modifyUser.getPassword())){
                //密码参数为空，不修改密码
                if (userMapper.updateOneNoPassword(userDao)){
                    resultData.setMessage("用户信息更新成功");
                    resultData.setData(userDao);
                    return resultData;
                }
                return resultData;
            } else {
                if (modifyUser.getPassword().length() < UserConstant.PASSWORD_LENGTH_MIX) {
                    resultData.setMessage("密码小于6位，更新失败");
                    return resultData;
                } else if (modifyUser.getPassword().length() > UserConstant.PASSWORD_LENGTH_MAX){
                    resultData.setMessage("密码大于20位，更新失败");
                    return resultData;
                } else {
                    //密码加密
                    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                    userDao.setPassword(encoder.encode(modifyUser.getPassword()));
                    //修改最新的密码日期
                    userDao.setLastPasswordResetDate(new Date());
                    if (userMapper.updateOneWithPassword(userDao)){
                        resultData.setMessage("用户信息更新成功");
                        resultData.setData(userDao);
                        return resultData;
                    } else {
                        resultData.setMessage("用户信息更新失败");
                        return resultData;
                    }
                }
            }
        }
    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<UserDao> modifySystemSuperUser(ModifyUserBean modifyUser, ResultData<UserDao> resultData){
        return modify(modifyUser, resultData, UserConstant.SYSTEM_SUPER_USER_ID);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user')")
    public ResultData<UserDao> modifySystemUser(ModifyUserBean modifyUser, ResultData<UserDao> resultData){
        return modify(modifyUser, resultData, UserConstant.SYSTEM_USER_ID);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user')")
    public ResultData<UserDao> modifyAdmin(ModifyUserBean modifyUser, ResultData<UserDao> resultData){
        return modify(modifyUser, resultData, UserConstant.ADMIN_ID);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user') or hasRole('admin')")
    public ResultData<UserDao> modifySuperUser(ModifyUserBean modifyUser, ResultData<UserDao> resultData){
        return modify(modifyUser, resultData, UserConstant.SUPER_USER_ID);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user') or hasRole('admin') or hasRole('super_user')")
    public ResultData<UserDao> modifyUser(ModifyUserBean modifyUser, ResultData<UserDao> resultData){
        return modify(modifyUser, resultData, UserConstant.USER_ID);
    }

}
