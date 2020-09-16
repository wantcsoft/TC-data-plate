package com.tcsoft.security.service.user;


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
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserDeleteService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    /**
     * 删除方法总入口
     * @param deleteUserId
     * @return
     */
    public ResultData<String> delete(int deleteUserId, Authentication authentication){
        ResultData<String> resultData = new ResultData<>();
        List<UserServiceBean> list = userMapper.selectUserById(deleteUserId);
        if (list.size() == 0){
            resultData.setCode(401);
            resultData.setMessage("用户不存在");
        }else {
            UserServiceBean userService = list.get(0);
            // 删除系统用户
            if (UserConstant.SYSTEM_USER.equals(userService.getRole())){
                return deleteSystemUser(deleteUserId);
            // 删除医院用户
            }else if (UserConstant.HOSPITAL.equals(userService.getRole())){
                JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
                UserServiceBean jwtUserService = userMapper.selectUserById(jwtUser.getUserId()).get(0);
                if (!UserConstant.SYSTEM_GROUP.equals(jwtUserService.getGroup()) &&
                        !jwtUserService.getGroup().equals(userService.getGroup())){
                    resultData.setCode(401);
                    resultData.setMessage("权限不足");
                    return resultData;
                }
                return deleteHospital(deleteUserId);
            }
        }
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> deleteSystemUser(int id){
        return deleteById(id);
    }

    private ResultData<String> deleteHospital(int id){
        return deleteById(id);
    }

    /**
     * 删除的方法
     * @param id
     * @return
     */
    private ResultData<String> deleteById(int id){
        ResultData<String> resultData = new ResultData<>();
        if (userMapper.deleteById(id) == 1){
            resultData.setCode(200);
            resultData.setMessage("删除成功");
        } else {
            resultData.setCode(401);
            resultData.setMessage("删除失败");
        }
        return resultData;
    }

}
