package com.tcsoft.security.service.user;

import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.CheckUserToken;
import com.tcsoft.security.utils.UserConstant;
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
    private UserRoleMapper userRoleMapper;

    /**
     * 检查username是否重复的情况
     * @param username
     * @return
     */
    private boolean checkUserName(String username){
        UserDao userDao = userMapper.queryUserByName(username);
        return userDao == null;
    }

    /**
     * 注册的通用方法，供所有人调用
     * @param userServiceBean
     * @return
     */
    public ResultData<UserDao> register(UserServiceBean userServiceBean){
        ResultData<UserDao> resultData = new ResultData<>();
        String message = CheckUserToken.checkToken(userServiceBean.getToken());
        if (!"".equals(message)){
            resultData.setCode(401);
            resultData.setMessage(message);
            return resultData;
        }
        String userName = CheckUserToken.getTokenUserName(userServiceBean.getToken());
        if (!"".equals(userName)){
            resultData.setCode(401);
            resultData.setMessage("token异常");
            return resultData;
        }
        //检查用户名重名情况
        if (checkUserName(userServiceBean.getUsername())){
            String password = userServiceBean.getPassword();
            //密码长度检查
            if (password.length() < UserConstant.PASSWORD_MIN_LENGTH){
                resultData.setCode(401);
                resultData.setMessage("注册失败，密码长度小于6位");
                return resultData;
            } else {
                //权限检查
                if (CheckUserToken.checkAuthority(userName, userServiceBean.getUserId())){
                    resultData.setCode(401);
                    resultData.setMessage("权限不足");
                }else {
                    UserDao userDao = new UserDao();
                    userDao.setGroupId(userServiceBean.getGroupId());
                    userDao.setRoleId(userServiceBean.getRoleId());
                    userDao.setUsername(userServiceBean.getUsername());
                    //密码加密
                    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                    userDao.setPassword(encoder.encode(password));
                    //密码最新一次修改日期
                    userDao.setLastPasswordResetDate(new Date());
                    userDao.setAccountNonLocked(userServiceBean.isAccountNonLocked());
                    userDao.setEnabled(userServiceBean.isEnabled());
                    if (userMapper.insertOne(userDao)){
                        resultData.setMessage("注册成功");
                        resultData.setData(userDao);
                    }else {
                        resultData.setCode(401);
                        resultData.setMessage("注册失败");
                    }
                }
            }
        }else {
            //重名
            resultData.setCode(401);
            resultData.setMessage("注册失败，用户名已被注册");
        }
        return resultData;
    }
}
