package com.tcsoft.security.controller;

import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.service.user.UserDeleteService;
import com.tcsoft.security.service.user.UserLoginService;
import com.tcsoft.security.service.user.UserModifyService;
import com.tcsoft.security.service.user.UserRegisterService;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
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
    @Resource
    private UserRegisterService userRegisterService;
    @Resource
    private UserModifyService userModifyService;

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
                    //删除操作,根据userId删除用户
                    if (userServiceBean.getUserId()==null || userServiceBean.getToken()==null){
                        return nullParameter();
                    }else {
                        int deleteUserId = userServiceBean.getUserId();
                        String deleteToken = userServiceBean.getToken();
                        return userDeleteService.delete(deleteUserId, deleteToken);
                    }
                case UserConstant.CREATE:
                    //创建操作
                    if (userServiceBean.getGroupId()==null || userServiceBean.getRoleId()==null ||
                    userServiceBean.getUsername()== null || userServiceBean.getPassword()==null ||
                    userServiceBean.getToken()==null){
                        return nullParameter();
                    }else {
                        return userRegisterService.register(userServiceBean);
                    }
                case UserConstant.QUERY:
                    //查询操作

                    return null;
                case UserConstant.MODIFY:
                    //修改操作
                    if (userServiceBean.getUserId()==null || userServiceBean.getGroupId()==null ||
                    userServiceBean.getRoleId()==null || userServiceBean.getUsername()==null ||
                    userServiceBean.getPassword()==null || userServiceBean.getToken()==null){
                        return nullParameter();
                    }else {
                        return userModifyService.modify(userServiceBean);
                    }
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

    @GetMapping("/user")
    public ResultData getUser(){

        return nullParameter();
    }

    /**
     * 缺少必要的参数
     * @return
     */
    private ResultData<String> nullParameter(){
        ResultData<String> resultData = new ResultData<>();
        resultData.setCode(401);
        resultData.setMessage("缺少必要参数");
        return resultData;
    }
}
