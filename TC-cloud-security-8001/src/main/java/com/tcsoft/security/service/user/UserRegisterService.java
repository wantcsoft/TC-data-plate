package com.tcsoft.security.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.mysqlmapper.UserGroupMapper;
import com.tcsoft.security.mysqlmapper.UserMapper;
import com.tcsoft.security.mysqlmapper.UserRoleMapper;
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
public class UserRegisterService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserGroupMapper groupMapper;
    @Resource
    private UserRoleMapper roleMapper;

    /**
     * 检查username是否被注册
     * @param username
     * @return
     */
    private boolean checkUserName(String username){
        UserDao userDao = userMapper.selectOne(new QueryWrapper<UserDao>()
                .eq("Username", username));
        return userDao == null;
    }

    /**
     * 注册的通用方法，供所有人调用
     * @param userServiceBean, authentication
     * @return
     */
    public ResultData<String> register(UserServiceBean userServiceBean,
                                        Authentication authentication){
        String group = userServiceBean.getGroup();
        String role = userServiceBean.getRole();
        if (UserConstant.SYSTEM_USER.equals(role) &&
                UserConstant.SYSTEM_GROUP.equals(group)){
            //创建系统用户
            return registerSystemUser(userServiceBean);
        }else if (UserConstant.HOSPITAL.equals(role)){
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            UserGroupDao jwtGroup = groupMapper.selectById(jwtUser.getGroupId());
            if (UserConstant.SYSTEM_GROUP.equals(jwtGroup.getGroup())){
                return registerHospital(userServiceBean);
            }else if (jwtGroup.getGroup().equals(group)){
                return registerHospital(userServiceBean);
            }
        }
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("权限不足");
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> registerSystemUser(UserServiceBean userServiceBean){
        return registerUser(userServiceBean);
    }

    private ResultData<String> registerHospital(UserServiceBean userServiceBean){
        return registerUser(userServiceBean);
    }

    private ResultData<String> registerUser(UserServiceBean userServiceBean){
        ResultData<String> resultData = new ResultData<>();
        //检查是否重名
        String username = userServiceBean.getUsername();
        if ("".equals(username)){
            resultData.setCode(401);
            resultData.setMessage("注册失败，用户名为空");
        }else if (checkUserName(username)){
            String password = userServiceBean.getPassword();
            //密码长度检查
            if (password.length() < UserConstant.PASSWORD_LENGTH_MIN ||
                    password.length() > UserConstant.PASSWORD_LENGTH_MAX){
                resultData.setCode(401);
                resultData.setMessage("注册失败，密码长度异常");
                return resultData;
            } else {
                UserDao userDao = new UserDao();
                userDao.setGroupId(groupMapper.selectOne(new QueryWrapper<UserGroupDao>()
                        .eq("`Group`", userServiceBean.getGroup())).getGroupId());
                userDao.setRoleId(roleMapper.selectOne(new QueryWrapper<UserRoleDao>()
                        .eq("`Role`", userServiceBean.getRole())).getRoleId());
                userDao.setUsername(userServiceBean.getUsername());
                //密码加密
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                userDao.setPassword(encoder.encode(password));
                //密码最新一次修改日期
                userDao.setLastPasswordResetDate(new Date());
                userDao.setAccountNonLocked(userServiceBean.isAccountNonLocked());
                userDao.setEnabled(userServiceBean.isEnabled());
                if (userMapper.insert(userDao) == 1){
                    resultData.setCode(200);
                    resultData.setMessage("注册成功");
                }else {
                    resultData.setCode(401);
                    resultData.setMessage("注册失败");
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
