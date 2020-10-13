package com.tcsoft.security.controller;

import com.tcsoft.security.entity.*;
import com.tcsoft.security.myExceptions.UserException;
import com.tcsoft.security.service.user.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 数据平台登录接口
 * @author big_john
 */
@RestController
public class AuthController {
    @Resource
    private UserLoginService userLoginService;

    /**
     * 大数据平台系统登录
     * @param loginBean
     * @return
     */
    @PostMapping("/login")
    public ResultData<String> login(@RequestBody UserServiceBean loginBean){
        if (loginBean.getUsername()==null || loginBean.getPassword()==null){
            throw new UserException("缺少必要参数");
        }else {
            return userLoginService.login(loginBean.getUsername(), loginBean.getPassword());
        }
    }

}
