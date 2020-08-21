package com.tcsoft.security.service.group;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mysqlmapper.UserGroupMapper;
import com.tcsoft.security.mysqlmapper.UserMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
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

    public ResultData<List<UserGroupDao>> getUserGroup(String username) {
        ResultData<List<UserGroupDao>> resultData = new ResultData<>();
        UserDao user = userMapper.selectOne(new QueryWrapper<UserDao>()
                .eq("userName", username));
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

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    public ResultData<String> createGroup(UserGroupDao groupDao){
        ResultData<String> resultData = new ResultData<>();
        System.out.println(groupDao);
        if (groupDao.getGroup()==null ||groupDao.getGroupDescription()==null){
            resultData.setCode(403);
            resultData.setMessage("操作失败");
        }else {
            UserGroupDao userGroupDao = userGroupMapper.selectOne(new QueryWrapper<UserGroupDao>()
                    .eq("`group`", groupDao.getGroup())
                    .or()
                    .eq("groupDescription", groupDao.getGroupDescription()));
            if (userGroupDao != null) {
                resultData.setCode(403);
                resultData.setMessage("操作失败");
            } else {
                if (userGroupMapper.insert(groupDao) == 1) {
                    resultData.setMessage("操作成功");
                } else {
                    resultData.setCode(403);
                    resultData.setMessage("操作失败");
                }
            }
        }
        return resultData;
    }

    @PreAuthorize("hasAnyRole('system_admin', 'system_user')")
    public ResultData<String> deleteGroup(UserGroupDao groupDao){
        ResultData<String> resultData = new ResultData<>();
        if (groupDao.getGroupId()==null || groupDao.getGroupId()== UserConstant.SYSTEM_GROUP_ID){
            resultData.setCode(403);
            resultData.setMessage("操作失败");
        }else {
            if (userGroupMapper.deleteById(groupDao.getGroupId())==1){
                resultData.setMessage("操作成功");
            }else {
                resultData.setCode(403);
                resultData.setMessage("操作失败");
            }
        }
        return resultData;
    }

//    @PreAuthorize("hasRole('system_user')")
    @PreAuthorize("hasAuthority('admin') and hasRole('system_user')")
    public ResultData<String> modifyGroup(UserGroupDao groupDao){
        ResultData<String> resultData = new ResultData<>();
        if (groupDao.getGroup()==null ||groupDao.getGroupDescription()==null || groupDao.getGroupId()==null){
            resultData.setCode(403);
            resultData.setMessage("操作失败");
        }else if (groupDao.getGroupId() == UserConstant.SYSTEM_GROUP_ID) {
            resultData.setCode(403);
            resultData.setMessage("操作失败");
        }else {
            UserGroupDao userGroupDao = userGroupMapper.selectOne(new QueryWrapper<UserGroupDao>()
                    .ne("groupId", groupDao.getGroupId())
                    .and(i -> {
                        i.eq("`group`", groupDao.getGroup())
                                .or()
                                .eq("groupDescription", groupDao.getGroupDescription());
                    }));
            if (userGroupDao != null) {
                resultData.setCode(403);
                resultData.setMessage("操作失败");
            } else {
                if (userGroupMapper.updateById(groupDao)==1){
                    resultData.setMessage("操作成功");
                }else {
                    resultData.setCode(403);
                    resultData.setMessage("操作失败");
                }
            }
        }
        return resultData;
    }

}
