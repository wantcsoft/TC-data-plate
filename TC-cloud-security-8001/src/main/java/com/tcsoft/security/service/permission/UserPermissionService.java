package com.tcsoft.security.service.permission;


import com.tcsoft.security.dao.UserPermissionDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.enums.ResultCode;
import com.tcsoft.security.mapper.UserPermissionMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户与权限的关联，业务逻辑处理
 * @author WMY
 */
@Service
public class UserPermissionService {

    @Resource
    private UserPermissionMapper permissionMapper;

    /**
     * 根据用户ID查询他的权限信息，只有系统管理员
     * @param userId
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    public ResultData<List<UserPermissionDao>> queryByUserId(int userId){
        ResultData<List<UserPermissionDao>> resultData = new ResultData<>();
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(permissionMapper.selectPermissionByUserId(userId));
        return resultData;
    }

    /**
     * 修改用户的权限信息，并开始事务，只有用户管理员
     * @param userId
     * @param list
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    @Transactional(rollbackFor = Exception.class)
    public ResultData<String> modifyByUserId(int userId, List<Integer> list){
        ResultData<String> resultData = new ResultData<>();
        try {
            permissionMapper.deletePermissionByUserId(userId);
            for (Integer authorityId:list){
                permissionMapper.insertPermission(userId, authorityId);
            }
            resultData.setResultCode(ResultCode.SUCCESS);
        }catch (Exception e){
            resultData.setResultCode(ResultCode.FAILED);
        }
        return resultData;
    }

}
