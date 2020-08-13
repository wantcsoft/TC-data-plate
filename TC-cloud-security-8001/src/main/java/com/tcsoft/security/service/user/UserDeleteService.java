package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserMapper;
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

    /**
     * 删除方法总入口
     * @param deleteUserId
     * @return
     */
    public ResultData<String> delete(int deleteUserId, Authentication authentication){
        UserDao deleteUserDao = userMapper.selectById(deleteUserId);
        if (deleteUserDao!=null){
            if (deleteUserDao.getRoleId()==UserConstant.SYSTEM_USER_ID){
                return deleteSystemUser(deleteUserId);
            }else if (deleteUserDao.getRoleId()==UserConstant.DEVELOPER_ID){
                return deleteDeveloper(deleteUserId);
            }else if (deleteUserDao.getRoleId()==UserConstant.HOSPITAL_ID){
                JwtUser jwtUser = (JwtUser) authentication.getPrincipal();
                if (jwtUser.getGroupId() != UserConstant.SYSTEM_GROUP_ID &&
                        !jwtUser.getGroupId().equals(deleteUserDao.getGroupId())){
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
        resultData.setMessage("用户信息异常");
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    private ResultData<String> deleteSystemUser(int id){
        return deleteById(id);
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    private ResultData<String> deleteDeveloper(int id){
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
