package com.tcsoft.security.service.group;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserGroupService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserGroupMapper userGroupMapper;

    public ResultData<List<UserGroupDao>> getUserGroup(String username, ResultData<List<UserGroupDao>> resultData) {
        UserDao user = userMapper.selectOne(new QueryWrapper<UserDao>()
                .eq("username", username));
        if (user == null){
            resultData.setCode(401);
            resultData.setMessage("操作失败");
            return resultData;
        }
        Integer groupId = user.getGroupId();
        List<UserGroupDao> userGroupDaoList = new ArrayList<>();
        if (groupId == 1){
            userGroupDaoList = userGroupMapper.selectList(null);

        }else {
            UserGroupDao userGroupDao = userGroupMapper.selectById(groupId);
            userGroupDaoList.add(userGroupDao);
        }
        resultData.setMessage("操作成功");
        resultData.setData(userGroupDaoList);
        return resultData;

    }
}
