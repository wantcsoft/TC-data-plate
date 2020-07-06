package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.QueryUserBean;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.mapper.UserRoleMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserQueryService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    public ResultData<List<QueryUserBean>> queryAllUser(String username, ResultData<List<QueryUserBean>> resultData) {
        List<QueryUserBean> userList;
        UserDao currentUser = userMapper.queryUserByName(username);
        Integer groupId = currentUser.getGroupId();
        Integer roleGrade = userMapper.queryUserRoleGrade(username);
        if (groupId == UserConstant.SYSTEM_GROUP_ID){
            // 系统级用户，可以查看所有医院用户信息,还有比自己等级低的系统用户
            Integer maxGrade = userRoleMapper.queryMaxGrade();
            if (roleGrade.equals(maxGrade)){
                // 这是系统管理员用户，权限最高
                userList = userMapper.systemAdminQueryAllUser();
            }else {
                // 其他系统用户查看比自己等级低的用户
                userList = userMapper.systemQueryAllUser(roleGrade);
            }
        }else {
            // 这是一个医院用户，只能查看本医院的用户
            userList = userMapper.hospitalQueryAllUser(groupId, roleGrade);
        }
        if (userList.size() != 0){
            resultData.setData(userList);
            resultData.setMessage("获取" + userList.size() + "条数据");
        }else {
            resultData.setMessage("获取0条数据");
        }
        return resultData;
    }
}
