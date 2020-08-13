package com.tcsoft.security.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author WMY
 */
@Service
public class DevelopRegisterService {

    private static final String DEVELOP_SECRET = "tcsoft";

    @Resource
    private UserMapper userMapper;

    public ResultData register(UserServiceBean userServiceBean){
        ResultData<String> resultData = new ResultData<>();
        String username = userServiceBean.getUsername();
        UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                .eq("user_name", username));
        if (userDao != null){
            resultData.setCode(401);
            resultData.setMessage("该账号已存在");
        }else {
            if (DEVELOP_SECRET.equals(userServiceBean.getToken())){
                String password = userServiceBean.getPassword();
                if (password.length()>= UserConstant.PASSWORD_LENGTH_MIN &&
                        password.length()<=UserConstant.PASSWORD_LENGTH_MAX){
                    UserDao userDao1 = new UserDao();
                    userDao1.setGroupId(UserConstant.SYSTEM_GROUP_ID);
                    userDao1.setRoleId(UserConstant.DEVELOPER);
                    userDao1.setUsername(username);
                    //密码加密
                    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                    userDao1.setPassword(encoder.encode(password));
                    //密码最新一次修改日期
                    userDao1.setLastPasswordResetDate(new Date());
                    if (userMapper.insert(userDao1) == 1){
                        resultData.setCode(200);
                        resultData.setMessage("注册成功");
                    }else {
                        resultData.setCode(401);
                        resultData.setMessage("注册失败");
                    }
                }else {
                    resultData.setCode(401);
                    resultData.setMessage("密码长度异常");
                }
            }else {
                resultData.setCode(401);
                resultData.setMessage("秘钥错误");
            }
        }
        return resultData;
    }

}
