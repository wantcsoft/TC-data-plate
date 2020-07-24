package com.tcsoft.security.service.user;


import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.mapper.UserMapper;
import com.tcsoft.security.utils.JwtTokenUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author big_john
 */
@Service
public class UserDeleteService {

    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private UserMapper userMapper;

    public ResultData<UserDao> delete(String deleteUsername, String deleteToken){
        ResultData<UserDao> resultData = new ResultData<>();
        String username = jwtTokenUtil.getUsernameFromToken(deleteToken);
        if (username == null){
            resultData.setCode(401);
            resultData.setMessage("token异常");
            return resultData;
        }
        Date date = jwtTokenUtil.getCreatedDateFromToken(deleteToken);
        if (date == null){
            resultData.setCode(401);
            resultData.setMessage("token异常");
            return resultData;
        }else {
            if (jwtTokenUtil.isTokenExpired(deleteToken)){
                resultData.setCode(401);
                resultData.setMessage("token过期");
                return resultData;
            }
        }
        UserRoleDao deleteUserRoleDao = userMapper.queryUserRole(deleteUsername);

        if (userMapper.deleteOne(deleteUsername)){
            resultData.setMessage("删除成功");
        } else {
            resultData.setMessage("删除失败");
        }
        return resultData;
    }

}
