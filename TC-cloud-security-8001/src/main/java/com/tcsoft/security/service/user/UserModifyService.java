package com.tcsoft.security.service.user;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
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
    private UserDao userDao;

    /**
     * 用户信息修改唯一入口
     * @param modifyUser
     * @param authentication
     * @return
     */
    public ResultData<String> modify(UserServiceBean modifyUser,
                                      Authentication authentication){
        userDao = userMapper.selectById(modifyUser.getUserId());
        if (userDao.getRoleId()==UserConstant.SYSTEM_USER_ID){
            return modifySystemUser(modifyUser);
        }else if (userDao.getRoleId()==UserConstant.DEVELOPER_ID){
            return modifyDeveloper(modifyUser);
        }else if (userDao.getRoleId()==UserConstant.HOSPITAL_ID &&
                userDao.getGroupId() != UserConstant.SYSTEM_GROUP_ID){
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            if (jwtUser.getGroupId()==UserConstant.SYSTEM_GROUP_ID){
                return modifyHospital(modifyUser);
            }else if (jwtUser.getGroupId().equals(userDao.getGroupId())) {
                return modifyHospital(modifyUser);
            }
        }
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("权限不足");
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> modifySystemUser(UserServiceBean modifyUser){
        return modifyUser(modifyUser);
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<String> modifyDeveloper(UserServiceBean modifyUser){
        return modifyUser(modifyUser);
    }

    private ResultData<String> modifyHospital(UserServiceBean modifyUser){
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
        if (modifyUser.getGroupId()==null){
            newUserDao.setGroupId(userDao.getGroupId());
        }else {
            newUserDao.setGroupId(modifyUser.getGroupId());
        }
        if (modifyUser.getRoleId()==null){
            newUserDao.setRoleId(userDao.getRoleId());
        }else {
            newUserDao.setRoleId(modifyUser.getRoleId());
        }
        if (modifyUser.getUsername()==null){
            newUserDao.setUsername(userDao.getUsername());
        }else {
            //检查新的用户名是否重名
            if (userMapper.selectOne(new QueryWrapper<UserDao>()
                    .eq("username", modifyUser.getUsername())
                    .ne("userId", modifyUser.getUserId())) != null){
                resultData.setCode(401);
                resultData.setMessage("用户名已存在");
            }else {
                newUserDao.setUsername(modifyUser.getUsername());
            }
        }
        newUserDao.setAccountNonLocked(modifyUser.isAccountNonLocked());
        newUserDao.setEnabled(modifyUser.isEnabled());
        if (modifyUser.getPassword() == null || "".equals(modifyUser.getPassword())){
            //密码参数为空，不修改密码
            if (userMapper.updateById(newUserDao) == 1){
                resultData.setCode(200);
                resultData.setMessage("用户信息更新成功");
            }else {
                resultData.setCode(401);
                resultData.setMessage("用户信息更新失败");
            }
        } else if (modifyUser.getPassword().length() < UserConstant.PASSWORD_LENGTH_MIN ||
                    modifyUser.getPassword().length() > UserConstant.PASSWORD_LENGTH_MAX) {
            resultData.setCode(401);
            resultData.setMessage("密码长度异常，更新失败");
        }else {
            //密码加密
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            newUserDao.setPassword(encoder.encode(modifyUser.getPassword()));
            //修改最新的密码日期
            newUserDao.setLastPasswordResetDate(new Date());
            if (userMapper.updateById(newUserDao) == 1){
                resultData.setCode(200);
                resultData.setMessage("用户信息更新成功");
            } else {
                resultData.setCode(401);
                resultData.setMessage("用户信息更新失败");
            }
        }
        return resultData;
    }
}
