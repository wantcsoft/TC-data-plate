package com.tcsoft.security.service.user;

import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.RegisterUserBean;
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
public class UserRegisterService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserGroupMapper userGroupMapper;

    /**
     * 需要拥有系统管理员权限才能注册系统超级用户
     * @param registerUserBean
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    public ResultData<UserDao> registerSystemSuperUser(RegisterUserBean registerUserBean) {
        return register(registerUserBean, UserConstant.SYSTEM_GROUP_ID, UserConstant.SYSTEM_SUPER_USER_ID);
    }

    /**
     * 需要拥有系统管理员权限，系统超级用户权限才能注册系统普通用户
     * @param registerUserBean
     * @return
     */
    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user')")
    public ResultData<UserDao> registerSystemUser(RegisterUserBean registerUserBean) {
        return register(registerUserBean, UserConstant.SYSTEM_GROUP_ID, UserConstant.SYSTEM_USER_ID);
    }

    /**
     * 需要拥有系统管理员权限，系统超级用户权限，系统普通用户才能注册医院管理员
     * @param registerUserBean
     * @return
     */
    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user')")
    public ResultData<UserDao> registerAdmin(RegisterUserBean registerUserBean){
        String groupDescription = registerUserBean.getGroupDescription();
        UserGroupDao userGroupDao = userGroupMapper.queryGroupByDescription(groupDescription);
        return register(registerUserBean, userGroupDao.getGroupId(), UserConstant.ADMIN_ID);
    }

    /**
     * 需要拥有系统管理员权限，系统超级用户权限，系统普通用户，医院管理员才能注册医院超级用户
     * @param registerUserBean
     * @return
     */
    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user') or hasRole('admin')")
    public ResultData<UserDao> registerSuperUser(RegisterUserBean registerUserBean){
        String groupDescription = registerUserBean.getGroupDescription();
        UserGroupDao userGroupDao = userGroupMapper.queryGroupByDescription(groupDescription);
        return register(registerUserBean, userGroupDao.getGroupId(), UserConstant.SUPER_USER_ID);
    }

    /**
     * 需要拥有系统管理员权限，系统超级用户权限，系统普通用户，医院管理员，医院超级用户才能注册医院普通用户
     * @param registerUserBean
     * @return
     */
    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user') or hasRole('admin') or hasRole('super_user')")
    public ResultData<UserDao> registerUser(RegisterUserBean registerUserBean){
        String groupDescription = registerUserBean.getGroupDescription();
        UserGroupDao userGroupDao = userGroupMapper.queryGroupByDescription(groupDescription);
        return register(registerUserBean, userGroupDao.getGroupId(), UserConstant.USER_ID);
    }

    /**
     * 检查username是否重复的情况
     * @param username
     * @return
     */
    public boolean checkUserName(String username){
        UserDao userDao = userMapper.queryUserByName(username);
        return userDao == null;
    }

    /**
     * 注册的通用方法，供所有人调用
     * @param registerUserBean
     * @param groupId
     * @param roleId
     * @return
     */
    public ResultData<UserDao> register(RegisterUserBean registerUserBean, int groupId, int roleId){
        ResultData<UserDao> resultData = new ResultData<>();
        if (registerUserBean.getUsername() == null){
            resultData.setMessage("注册失败，没有用户名");
            return resultData;
        }else if (checkUserName(registerUserBean.getUsername())){
            //没有重名
            String password = registerUserBean.getPassword();
            if (password.length() < UserConstant.PASSWORD_MIN_LENGTH){
                resultData.setMessage("注册失败，密码长度小于6位");
                return resultData;
            } else {
                UserDao userDao = new UserDao();
                userDao.setGroupId(groupId);
                userDao.setRoleId(roleId);
                userDao.setUsername(registerUserBean.getUsername());
                //密码加密
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                userDao.setPassword(encoder.encode(password));
                //密码最新一次修改日期
                userDao.setLastPasswordResetDate(new Date());
                userDao.setAccountNonLocked(registerUserBean.isAccountNonLocked());
                userDao.setEnabled(registerUserBean.isEnabled());
                if (userMapper.insertOne(userDao)){
                    resultData.setMessage("注册成功");
                    resultData.setData(userDao);
                    return resultData;
                }else {
                    resultData.setMessage("注册失败");
                    return resultData;
                }
            }
        }else {
            //重名
            resultData.setMessage("注册失败，用户名已被注册");
            return resultData;
        }
    }

}
