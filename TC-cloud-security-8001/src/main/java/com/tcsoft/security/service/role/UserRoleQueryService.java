package com.tcsoft.security.service.role;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.enums.ResultCode;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户角色信息查询接口
 * @author big_john
 */
@Service
public class UserRoleQueryService {

    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserGroupMapper userGroupMapper;

    /**
     * 查询出比自己角色更低的所有角色
     * @param role
     * @param groupId
     * @return
     */
    public ResultData<List<UserRoleDao>> queryAllRole(String role, Integer groupId){
        ResultData<List<UserRoleDao>> resultData = new ResultData<>();
        UserGroupDao groupDao = userGroupMapper.selectById(groupId);
        if ("".equals(role)) {
            resultData.setResultCode(ResultCode.FAILED);
        }else if (UserConstant.SYSTEM_ADMIN.equals(role)){
            List<UserRoleDao> list = userRoleMapper.selectList(null);
            resultData.setResultCode(ResultCode.SUCCESS);
            resultData.setData(list);
        }else {
            List<UserRoleDao> list = userRoleMapper.selectList(new QueryWrapper<UserRoleDao>()
                    .eq("Role", UserConstant.HOSPITAL));
            resultData.setResultCode(ResultCode.SUCCESS);
            resultData.setData(list);
        }
        return resultData;
    }
}
