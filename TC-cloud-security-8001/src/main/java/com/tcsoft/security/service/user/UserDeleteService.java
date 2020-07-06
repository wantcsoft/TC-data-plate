package com.tcsoft.security.service.user;


import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author big_john
 */
@Service
public class UserDeleteService {

    @Resource
    private UserMapper userMapper;

    @PreAuthorize("hasRole('system_admin')")
    public ResultData deleteSystemSuperUser(String username){
        return deleteUser(username);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user')")
    public ResultData deleteSystemUser(String username){
        return deleteUser(username);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user')")
    public ResultData deleteAdmin(String username){
        return deleteUser(username);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user') or hasRole('admin')")
    public ResultData deleteSuperUser(String username){
        return deleteUser(username);
    }

    @PreAuthorize("hasRole('system_admin') or hasRole('system_super_user') or hasRole('system_user') or hasRole('admin') or hasRole('super_user')")
    public ResultData deleteUser(String username){
        return deleteUser(username);
    }

    public ResultData delete(String username){
        ResultData<String> resultData = new ResultData<>();
        if (userMapper.deleteOne(username)){
            resultData.setMessage("删除成功");
        } else {
            resultData.setMessage("删除失败");
        }
        return resultData;
    }

}
