package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        UserDao deleteUserDao = userMapper.selectById(deleteUserId);
        if (deleteUserDao!=null){
            UserRoleDao deleteRole = userRoleMapper.selectById(deleteUserDao.getRoleId());
            if (UserConstant.SYSTEM_USER.equals(deleteRole.getRole())){
                return deleteSystemUser(deleteUserId);
            }else if (UserConstant.HOSPITAL.equals(deleteRole.getRole())){
                JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
                UserGroupDao jwtGroup = userGroupMapper.selectById(jwtUser.getGroupId());
                UserGroupDao deleteGroup = userGroupMapper.selectById(deleteUserDao.getGroupId());
                if (!UserConstant.SYSTEM_GROUP.equals(jwtGroup.getGroup()) &&
                        !jwtGroup.getGroup().equals(deleteGroup.getGroup())){
                    ResultData<String> resultData = new ResultData<>();
                    resultData.setCode(401);
                    resultData.setMessage("权限不足");
                    return resultData;
                }
                return deleteHospital(deleteUserId);
            }
        }
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("用户不存在");
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
