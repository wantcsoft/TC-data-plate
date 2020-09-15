package com.tcsoft.security.service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserModifyService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    /**
     * 用户信息修改唯一入口
     * @param modifyUser
     * @param authentication
     * @return
     */
    public ResultData<String> modify(UserServiceBean modifyUser,
                                      Authentication authentication){
        List<UserServiceBean> list = userMapper.selectUserById(modifyUser.getUserId());
        if (list.size() == 0){
            ResultData<String> resultData = new ResultData<>();
            resultData.setCode(401);
            resultData.setMessage("用户不存在");
            return resultData;
        }else {
            UserServiceBean userServiceBean = list.get(0);
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            UserServiceBean jwtUserService = userMapper.selectUserById(jwtUser.getUserId()).get(0);
            if (UserConstant.SYSTEM_USER.equals(userServiceBean.getRole()) ||
                    UserConstant.SYSTEM_ADMIN.equals(userServiceBean.getRole())){
                return systemAdminModify(modifyUser);
            }else if (UserConstant.HOSPITAL.equals(userServiceBean.getRole()) &&
                    UserConstant.SYSTEM_GROUP.equals(jwtUserService.getGroup())){
                return systemUserModify(modifyUser);
            }else if (UserConstant.HOSPITAL.equals(userServiceBean.getRole()) &&
                    !UserConstant.SYSTEM_GROUP.equals(jwtUserService.getGroup())){
                return hospitalModify(modifyUser);
            }
        }
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("修改失败");
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> systemAdminModify(UserServiceBean modifyUser){
        return checkModify(modifyUser);
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<String> systemUserModify(UserServiceBean modifyUser){
        return checkModify(modifyUser);
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user', 'hospital')")
    private ResultData<String> hospitalModify(UserServiceBean modifyUser){
        return checkModify(modifyUser);
    }

    private ResultData<String> checkModify(UserServiceBean modifyUser){
        if (UserConstant.SYSTEM_ADMIN.equals(modifyUser.getRole())){
            return modifyToSystem(modifyUser);
        }else if (UserConstant.SYSTEM_USER.equals(modifyUser.getRole())){
            return modifyToSystemUser(modifyUser);
        }else if (UserConstant.HOSPITAL.equals(modifyUser.getRole())){
            return modifyToHospital(modifyUser);
        }else {
            ResultData<String> resultData = new ResultData<>();
            resultData.setCode(401);
            resultData.setMessage("修改失败");
            return resultData;
        }
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> modifyToSystem(UserServiceBean modifyUser){
        return modifyUser(modifyUser);
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<String> modifyToSystemUser(UserServiceBean modifyUser){
        return modifyUser(modifyUser);
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user', 'hospital')")
    private ResultData<String> modifyToHospital(UserServiceBean modifyUser){
        return modifyUser(modifyUser);
    }

    /**
     * 用户信息修改的具体方法
     * @param modifyUser
     * @return
     */
    private ResultData<String> modifyUser(UserServiceBean modifyUser){
        ResultData<String> resultData = new ResultData<>();
        UserDao newUserDao = new UserDao();
        newUserDao.setUserId(modifyUser.getUserId());
        newUserDao.setRoleId(userRoleMapper.selectOne(new QueryWrapper<UserRoleDao>()
                .eq("`Role`", modifyUser.getRole())).getRoleId());
        newUserDao.setGroupId(userGroupMapper.selectOne(new QueryWrapper<UserGroupDao>()
                .eq("`Group`", modifyUser.getGroup())).getGroupId());
        if (modifyUser.getUsername() != null && !"".equals(modifyUser.getUsername())){
            List<UserDao> list = userMapper.selectList(new QueryWrapper<UserDao>()
                    .eq("UserName", modifyUser.getUsername()));
            if (list.size() == 0){
                resultData.setCode(401);
                resultData.setMessage("用户名已被使用");
                return resultData;
            }else {
                newUserDao.setUsername(modifyUser.getUsername());
            }
        }
        if (modifyUser.getPassword() != null && !"".equals(modifyUser.getPassword())){
            if (modifyUser.getPassword().length() < UserConstant.PASSWORD_LENGTH_MIN ||
                    modifyUser.getPassword().length() > UserConstant.PASSWORD_LENGTH_MAX) {
                resultData.setCode(401);
                resultData.setMessage("密码长度异常，更新失败");
                return resultData;
            }else {
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                newUserDao.setPassword(encoder.encode(modifyUser.getPassword()));
                newUserDao.setLastPasswordResetDate(new Date());
            }
        }
        newUserDao.setAccountNonLocked(modifyUser.isAccountNonLocked());
        newUserDao.setEnabled(modifyUser.isEnabled());
        if (userMapper.updateById(newUserDao) == 1){
            resultData.setCode(200);
            resultData.setMessage("用户信息更新成功");
        }else{
            resultData.setCode(401);
            resultData.setMessage("用户信息更新失败");
        }
        return resultData;
    }
}
