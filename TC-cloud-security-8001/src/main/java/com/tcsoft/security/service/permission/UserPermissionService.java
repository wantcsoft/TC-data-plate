package com.tcsoft.security.service.permission;


import com.tcsoft.security.dao.UserPermissionDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserPermissionMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WMY
 */
@Service
public class UserPermissionService {
    @Resource
    private UserPermissionMapper permissionMapper;

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<List<UserPermissionDao>> queryByUserId(int userId){
        ResultData<List<UserPermissionDao>> resultData = new ResultData<>();
        resultData.setMessage("获取成功");
        resultData.setData(permissionMapper.selectPermissionByUserId(userId));
        return resultData;
    }

    /**
     * 修改用户的权限信息，并开始事务
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
            resultData.setMessage("操作成功");
        }catch (Exception e){
            resultData.setCode(401);
            resultData.setMessage("操作失败");
        }
        return resultData;
    }

}
