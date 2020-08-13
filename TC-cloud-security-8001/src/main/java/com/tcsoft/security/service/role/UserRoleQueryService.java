package com.tcsoft.security.service.role;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserRoleQueryService {

    @Resource
    private UserRoleMapper userRoleMapper;
    @Resource
    private UserMapper userMapper;

    public ResultData<List<UserRoleDao>> queryAllRole(String username, ResultData<List<UserRoleDao>> resultData){
        int grade = userRoleMapper.selectById(userMapper.selectOne(
                new QueryWrapper<UserDao>()
                        .eq("username", username))
                                .getRoleId()).getRoleGrade();
        List<UserRoleDao> userRoleDaoList = userRoleMapper.selectList(
                new QueryWrapper<UserRoleDao>()
                    .lt("roleGrade", grade));
        resultData.setData(userRoleDaoList);
        resultData.setMessage("用户角色获取成功");
        return resultData;
    }
}
