package com.tcsoft.security.service.authority;

import com.tcsoft.security.dao.UserAuthorityDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mysqlmapper.UserAuthorityMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WMY
 */
@Service
public class UserAuthorityService {

    @Resource
    private UserAuthorityMapper authorityMapper;

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<List<UserAuthorityDao>> queryAll(){
        ResultData<List<UserAuthorityDao>> resultData = new ResultData<>();
        resultData.setMessage("获取成功");
        resultData.setData(authorityMapper.selectList(null));
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> createAuthority(UserAuthorityDao dao){
        ResultData<String> resultData = new ResultData<>();
        if (authorityMapper.insert(dao) == 1){
            resultData.setMessage("操作成功");
        }else {
            resultData.setCode(401);
            resultData.setMessage("操作失败");
        }
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> deleteAuthority(UserAuthorityDao dao){
        ResultData<String> resultData = new ResultData<>();
        if (authorityMapper.deleteById(dao.getAuthorityId()) == 1){
            resultData.setMessage("操作成功");
        }else {
            resultData.setCode(401);
            resultData.setMessage("操作失败");
        }
        return resultData;
    }

    @PreAuthorize("hasRole('system_admin')")
    public ResultData<String> modifyAuthority(UserAuthorityDao dao){
        ResultData<String> resultData = new ResultData<>();
        if (authorityMapper.updateById(dao) == 1){
            resultData.setMessage("操作成功");
        }else {
            resultData.setCode(401);
            resultData.setMessage("操作失败");
        }
        return resultData;
    }

}
