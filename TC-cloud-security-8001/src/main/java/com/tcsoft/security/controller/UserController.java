package com.tcsoft.security.controller;

import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.service.user.UserDeleteService;
import com.tcsoft.security.service.user.UserLoginService;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author WMY
 */
@RestController
public class UserController {

    @Resource
    private UserLoginService userLoginService;
    @Resource
    private UserDeleteService userDeleteService;


    @PostMapping("/user")
    public ResultData userService(@RequestBody UserServiceBean userServiceBean){
        if (userServiceBean.getType() != null){
            switch (userServiceBean.getType()) {
                case UserConstant.LOGIN:
                    //获取token
                    if (userServiceBean.getUsername()==null || userServiceBean.getPassword()==null){
                        return nullParameter();
                    }else {
                        String loginUsername = userServiceBean.getUsername();
                        String loginPassword = userServiceBean.getPassword();
                        return userLoginService.login(loginUsername, loginPassword);
                    }
                case UserConstant.DELETE:
                    //删除操作
                    if (userServiceBean.getUsername()==null || userServiceBean.getToken()==null){
                        return nullParameter();
                    }else {
                        String deleteUsername = userServiceBean.getUsername();
                        String deleteToken = userServiceBean.getToken();
                        return userDeleteService.delete(deleteUsername, deleteToken);
                    }
                case UserConstant.CREATE:
                    //创建操作

                    return null;
                case UserConstant.QUERY:
                    //查询操作

                    return null;
                case UserConstant.MODIFY:
                    //修改操作

                    return null;
                default:
                    ResultData<String> resultData = new ResultData<>();
                    resultData.setCode(401);
                    resultData.setMessage("type类型不正确");
                    return resultData;
            }
        }else {
            ResultData<String> resultData = new ResultData<>();
            resultData.setCode(401);
            resultData.setMessage("type没有值");
            return resultData;
        }
    }

    public ResultData<String> nullParameter(){
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("缺少必要参数");
        return resultData;
    }
}
