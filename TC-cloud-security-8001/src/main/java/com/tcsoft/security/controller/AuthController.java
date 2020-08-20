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
    @Resource
    private DevelopRegisterService developRegisterService;

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
     * 用户登录认证,注册开发者账号接口
     * @param userServiceBean
     * @return
     */
    @PostMapping("/develop/register")
    public ResultData<String> createAuthenticationToken(
            @RequestBody UserServiceBean userServiceBean){
        //开发者注册账号
        if (userServiceBean.getUsername()==null || userServiceBean.getPassword()==null){
            return nullParameter();
        }else {
            return developRegisterService.register(userServiceBean);
        }
    }

    /**
     * 开发者登录接口
     * @param loginBean
     * @return
     */
    @PostMapping("/develop/login")
    public ResultData<String> developLogin(@RequestBody UserServiceBean loginBean){
        if (loginBean.getUsername()==null || loginBean.getPassword()==null){
            return nullParameter();
        }else {
            return userLoginService.developLogin(loginBean.getUsername(), loginBean.getPassword());
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
