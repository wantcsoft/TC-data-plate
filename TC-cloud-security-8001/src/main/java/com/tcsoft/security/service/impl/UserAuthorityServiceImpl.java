package com.tcsoft.security.service.impl;


import com.tcsoft.security.dao.UserAuthorityDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserAuthorityMapper;
import com.tcsoft.security.service.UserAuthorityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author big_john
 */
@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {

    @Resource
    private UserAuthorityMapper userAuthorityMapper;

    @Override
    public ResultData getUserAuthority(String username) {
        ResultData<List<UserAuthorityDao>> resultData = new ResultData<>();
        resultData.setCode(200);
        resultData.setMessage("操作成功");
        resultData.setData(userAuthorityMapper.queryOwnAuthority(username));
        return resultData;
    }
}
