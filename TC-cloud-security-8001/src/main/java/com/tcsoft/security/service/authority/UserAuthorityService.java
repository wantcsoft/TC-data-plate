package com.tcsoft.security.service.authority;

import com.tcsoft.security.dao.UserAuthorityDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.enums.ResultCode;
import com.tcsoft.security.mapper.UserAuthorityMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限接口业务逻辑处理部分
 * @author WMY
 */
@Service
public class UserAuthorityService {

    @Resource
    private UserAuthorityMapper authorityMapper;

    /**
     * 查询所有的权限信息，只有系统管理员
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    public ResultData<List<UserAuthorityDao>> queryAll(){
        ResultData<List<UserAuthorityDao>> resultData = new ResultData<>();
        resultData.setResultCode(ResultCode.SUCCESS);
        resultData.setData(authorityMapper.selectList(null));
        return resultData;
    }

    /**
     * 创建一个新的权限信息，有系统管理员
     * @param dao
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> createAuthority(UserAuthorityDao dao){
        ResultData<String> resultData = new ResultData<>();
        if (authorityMapper.insert(dao) == 1){
            resultData.setResultCode(ResultCode.SUCCESS);
        }else {
            resultData.setResultCode(ResultCode.FAILED);
        }
        return resultData;
    }

    /**
     * 删除一个权限信息，有系统管理员
     * @param dao
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> deleteAuthority(UserAuthorityDao dao){
        ResultData<String> resultData = new ResultData<>();
        if (authorityMapper.deleteById(dao.getAuthorityId()) == 1){
            resultData.setResultCode(ResultCode.SUCCESS);
        }else {
            resultData.setResultCode(ResultCode.FAILED);
        }
        return resultData;
    }

    /**
     * 修改权限信息，有系统管理员
     * @param dao
     * @return
     */
    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> modifyAuthority(UserAuthorityDao dao){
        ResultData<String> resultData = new ResultData<>();
        if (authorityMapper.updateById(dao) == 1){
            resultData.setResultCode(ResultCode.SUCCESS);
        }else {
            resultData.setResultCode(ResultCode.FAILED);
        }
        return resultData;
    }

}
