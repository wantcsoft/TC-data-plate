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
import java.util.List;

/**
 * 用户信息修改业务逻辑
 * @author big_john
 */
@Service
public class UserModifyService {

    @Resource
    private UserMapper userMapper;

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
            // 自己修改自己的信息
            if (modifyUser.getUserId().equals(jwtUser.getUserId())){
                return modifySelf(modifyUser);
            }
            UserServiceBean jwtUserService = userMapper.selectUserById(jwtUser.getUserId()).get(0);
            if (UserConstant.SYSTEM_USER.equals(userServiceBean.getRole())){
                return modifySystemUser(modifyUser);
            }else if (UserConstant.HOSPITAL.equals(userServiceBean.getRole()) &&
                        (   UserConstant.SYSTEM_GROUP.equals(jwtUserService.getGroup()) ||
                            userServiceBean.getGroup().equals(jwtUserService.getGroup())    )){
                return modifyHospital(modifyUser);
            }
        }
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("修改失败");
        return resultData;
    }

    /**
     * 被修改的是系统用户
     * @param modifyUser
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> modifySystemUser(UserServiceBean modifyUser){
        return checkModify(modifyUser);
    }

    /**
     * 被修改的是医院用户
     * @param modifyUser
     * @return
     */
    @PreAuthorize("hasAnyRole('system_admin', 'system_user', 'hospital')")
    private ResultData<String> modifyHospital(UserServiceBean modifyUser){
        return checkModify(modifyUser);
    }

    /**
     * 检查一下需要修改成什么用户
     * @param modifyUser
     * @return
     */
    private ResultData<String> checkModify(UserServiceBean modifyUser){
        UserServiceBean userService = userMapper.selectUserById(modifyUser.getUserId()).get(0);
        if (UserConstant.SYSTEM_USER.equals(userService.getRole())){
            return modifyToSystemUser(modifyUser);
        }else if (UserConstant.HOSPITAL.equals(userService.getRole())){
            return modifyToHospital(modifyUser);
        }else {
            ResultData<String> resultData = new ResultData<>();
            resultData.setCode(401);
            resultData.setMessage("修改失败");
            return resultData;
        }
    }

    /**
     * 修改为系统用户
     * @param modifyUser
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> modifyToSystemUser(UserServiceBean modifyUser){
        return modifyUser(modifyUser);
    }

    /**
     * 修改为医院用户
     * @param modifyUser
     * @return
     */
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
        newUserDao.setRoleId(modifyUser.getRoleId());
        if (modifyUser.getGroupId() != null){
            newUserDao.setGroupId(modifyUser.getGroupId());
        }
        if (modifyUser.getUsername() != null && !"".equals(modifyUser.getUsername())){
            List<UserDao> list = userMapper.selectList(new QueryWrapper<UserDao>()
                    .eq("UserName", modifyUser.getUsername())
                    .ne("UserID", modifyUser.getUserId()));
            if (list.size() != 0){
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

    /**
     * 自己修改自己的用户名或者密码
     * @param modifyUser
     * @return
     */
    private ResultData<String> modifySelf(UserServiceBean modifyUser){
        ResultData<String> resultData = new ResultData<>();
        UserDao userDao = userMapper.selectById(modifyUser.getUserId());
        if (modifyUser.getUsername() != null && !"".equals(modifyUser.getUsername())){
            List<UserDao> list = userMapper.selectList(new QueryWrapper<UserDao>()
                    .eq("UserName", modifyUser.getUsername())
                    .ne("UserID", modifyUser.getUserId()));
            if (list.size() != 0){
                resultData.setCode(401);
                resultData.setMessage("用户名已被使用");
                return resultData;
            }else {
                userDao.setUsername(modifyUser.getUsername());
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
                userDao.setPassword(encoder.encode(modifyUser.getPassword()));
                userDao.setLastPasswordResetDate(new Date());
            }
        }
        if (userMapper.updateById(userDao) == 1){
            resultData.setCode(200);
            resultData.setMessage("用户信息更新成功");
        }else{
            resultData.setCode(401);
            resultData.setMessage("用户信息更新失败");
        }
        return resultData;
    }

}
