package com.tcsoft.security.service.user;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.enums.ResultCode;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.myExceptions.UserException;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 用户注册业务逻辑
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
        UserGroupDao groupDao = groupMapper.selectById(userServiceBean.getGroupId());
        UserRoleDao roleDao = roleMapper.selectById(userServiceBean.getRoleId());
        userServiceBean.setGroup(groupDao.getGroup());
        userServiceBean.setRole(roleDao.getRole());
        if (UserConstant.SYSTEM_USER.equals(roleDao.getRole())){
            //创建系统组的系统用户
            return registerSystemUser(userServiceBean);
        }else if (UserConstant.HOSPITAL.equals(roleDao.getRole())){
            JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
            UserGroupDao jwtGroup = groupMapper.selectById(jwtUser.getGroupId());
            if (UserConstant.SYSTEM_GROUP.equals(jwtGroup.getGroup()) ||
                    jwtGroup.getGroup().equals(groupDao.getGroup())){
                return registerHospital(userServiceBean);
            }
        }
        throw new UserException("创建失败");
    }

    /**
     * 注册系统用户，只有系统管理员
     * @param userServiceBean
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> registerSystemUser(UserServiceBean userServiceBean){
        return registerUser(userServiceBean);
    }

    /**
     * 注册医院用户
     * @param userServiceBean
     * @return
     */
    private ResultData<String> registerHospital(UserServiceBean userServiceBean){
        return registerUser(userServiceBean);
    }

    /**
     * 注册用户具体实现
     * @param userServiceBean
     * @return
     */
    private ResultData<String> registerUser(UserServiceBean userServiceBean){
        ResultData<String> resultData = new ResultData<>();
        //检查是否重名
        String username = userServiceBean.getUsername();
        if ("".equals(username)){
            throw new UserException("注册失败，用户名为空");
        }else if (checkUserName(username)){
            String password = userServiceBean.getPassword();
            //密码长度检查
            if (password.length() < UserConstant.PASSWORD_LENGTH_MIN ||
                    password.length() > UserConstant.PASSWORD_LENGTH_MAX){
                throw new UserException("注册失败，密码长度异常");
            } else {
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
                if (userMapper.insert(userDao) == 1){
                    resultData.setResultCode(ResultCode.SUCCESS);
                }else {
                    throw new UserException("注册失败");
                }
            }
        }else {
            throw new UserException("注册失败，用户名已被注册");
        }
        return resultData;
    }
}
