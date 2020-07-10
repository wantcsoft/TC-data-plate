package com.tcsoft.security.service.role;



import org.springframework.stereotype.Service;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserRoleMapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserRoleQueryService {

    @Resource
    private UserRoleMapper userRoleMapper;

    public ResultData<List<UserRoleDao>> queryAllRole(String username, ResultData<List<UserRoleDao>> resultData){
        List<UserRoleDao> userRoleDaoList = userRoleMapper.queryOwnRole(username);
        resultData.setData(userRoleDaoList);
        resultData.setMessage("用户角色获取成功");
        return resultData;
    }
}
