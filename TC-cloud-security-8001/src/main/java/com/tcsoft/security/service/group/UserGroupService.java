package com.tcsoft.security.service.group;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.enums.ResultCode;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author big_john
 */
@Service
public class UserGroupService {

    @Resource
    private UserGroupMapper userGroupMapper;

    public ResultData<List<UserGroupDao>> getUserGroup(String role, int groupId) {
        ResultData<List<UserGroupDao>> resultData = new ResultData<>();
        UserGroupDao groupDao = userGroupMapper.selectById(groupId);
        List<UserGroupDao> userGroupDaoList = new ArrayList<>();
        if (UserConstant.SYSTEM_ADMIN.equals(role)){
            // 系统管理员获取所有的群组信息
            userGroupDaoList = userGroupMapper.selectList(null);
        }else if (UserConstant.SYSTEM_GROUP.equals(groupDao.getGroup())){
            // 系统组可以查看所有的医院
            userGroupDaoList = userGroupMapper.selectList(new QueryWrapper<UserGroupDao>()
                    .ne("`Group`", UserConstant.SYSTEM_GROUP));
        }else {
            // 医院组只能查看自己所在医院
            UserGroupDao userGroupDao = userGroupMapper.selectById(groupId);
            userGroupDaoList.add(userGroupDao);
        }
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(userGroupDaoList);
        return resultData;

    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> createGroup(UserGroupDao groupDao){
        ResultData<String> resultData = new ResultData<>();
        System.out.println(groupDao);
        if (groupDao.getGroup()==null ||groupDao.getGroupDescription()==null){
            resultData.setResultCode(ResultCode.FAILED);
        }else {
            UserGroupDao userGroupDao = userGroupMapper.selectOne(new QueryWrapper<UserGroupDao>()
                    .eq("Group", groupDao.getGroup())
                    .or()
                    .eq("GroupDescription", groupDao.getGroupDescription()));
            if (userGroupDao != null) {
                resultData.setResultCode(ResultCode.FAILED);
            } else {
                if (userGroupMapper.insert(groupDao) == 1) {
                    resultData.setResultCode(ResultCode.SUCCESS);
                } else {
                    resultData.setResultCode(ResultCode.FAILED);
                }
            }
        }
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> deleteGroup(UserGroupDao groupDao){
        ResultData<String> resultData = new ResultData<>();
        if (groupDao.getGroupId()==null || UserConstant.SYSTEM_GROUP.equals(groupDao.getGroup())){
            resultData.setResultCode(ResultCode.FAILED);
        }else {
            if (userGroupMapper.deleteById(groupDao.getGroupId())==1){
                resultData.setResultCode(ResultCode.SUCCESS);
            }else {
                resultData.setResultCode(ResultCode.FAILED);
            }
        }
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> modifyGroup(UserGroupDao groupDao){
        ResultData<String> resultData = new ResultData<>();
        if (groupDao.getGroup()==null ||groupDao.getGroupDescription()==null || groupDao.getGroupId()==null){
            resultData.setResultCode(ResultCode.FAILED);
        }else if (UserConstant.SYSTEM_GROUP.equals(groupDao.getGroup())) {
            resultData.setResultCode(ResultCode.FAILED);
        }else {
            UserGroupDao userGroupDao = userGroupMapper.selectOne(new QueryWrapper<UserGroupDao>()
                    .ne("GroupID", groupDao.getGroupId())
                    .and(i -> {
                        i.eq("Group", groupDao.getGroup())
                                .or()
                                .eq("GroupDescription", groupDao.getGroupDescription());
                    }));
            if (userGroupDao != null) {
                resultData.setResultCode(ResultCode.FAILED);
            } else {
                if (userGroupMapper.updateById(groupDao)==1){
                    resultData.setResultCode(ResultCode.SUCCESS);
                }else {
                    resultData.setResultCode(ResultCode.FAILED);
                }
            }
        }
        return resultData;
    }

}
