package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.ModifyUserBean;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.CheckUserToken;
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
     * @return
     */
    public ResultData<UserDao> modify(UserServiceBean modifyUser){
        ResultData<UserDao> resultData = new ResultData<>();
        String message = CheckUserToken.checkToken(modifyUser.getToken());
        if (!"".equals(message)){
            resultData.setCode(401);
            resultData.setMessage(message);
            return resultData;
        }
        String userName = CheckUserToken.getTokenUserName(modifyUser.getToken());
        if (!"".equals(userName)){
            resultData.setCode(401);
            resultData.setMessage("token异常");
            return resultData;
        }
        if (userMapper.querySameUserName(modifyUser.getUserId(), modifyUser.getUsername()) != null){
            resultData.setCode(401);
            resultData.setMessage("用户名已存在");
            return resultData;
        } else {
            if (CheckUserToken.checkAuthority(userName, modifyUser.getUserId())){
                UserDao userDao = new UserDao();
                userDao.setUserId(modifyUser.getUserId());
                userDao.setGroupId(userGroupMapper.queryGroupByDescription(modifyUser.getGroupDescription()).getGroupId());
                userDao.setRoleId(modifyUser.getRoleId());
                userDao.setUsername(modifyUser.getUsername());
                userDao.setAccountNonLocked(modifyUser.isAccountNonLocked());
                userDao.setEnabled(modifyUser.isEnabled());
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
            }else {
                resultData.setCode(401);
                resultData.setMessage("权限不足");
                return resultData;
            }
        }
    }
}
