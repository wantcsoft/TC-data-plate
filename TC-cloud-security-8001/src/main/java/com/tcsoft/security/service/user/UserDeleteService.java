package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.CheckUserToken;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author big_john
 */
@Service
public class UserDeleteService {

    @Resource
    private UserMapper userMapper;

    public ResultData<String> delete(int deleteUserId, String deleteToken){
        ResultData<String> resultData = new ResultData<>();
        String message = CheckUserToken.checkToken(deleteToken);
        if (!"".equals(message)){
            resultData.setCode(401);
            resultData.setMessage(message);
            return resultData;
        }
        String userName = CheckUserToken.getTokenUserName(deleteToken);
        if (!"".equals(userName)){
            resultData.setCode(401);
            resultData.setMessage("token异常");
            return resultData;
        }
        if (CheckUserToken.checkAuthority(userName, deleteUserId)){
            if (userMapper.deleteOneByUserId(deleteUserId)){
                resultData.setCode(200);
                resultData.setMessage("删除成功");
            } else {
                resultData.setCode(200);
                resultData.setMessage("删除失败");
            }
        }else {
            resultData.setCode(401);
            resultData.setMessage("权限不足");
        }
        return resultData;
    }

}
