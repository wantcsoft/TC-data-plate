package com.tcsoft.security.controller;

import com.tcsoft.security.entity.*;
import com.tcsoft.security.service.user.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
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
            return nullParameter();
        }else {
            return userLoginService.login(loginBean.getUsername(), loginBean.getPassword());
        }
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
