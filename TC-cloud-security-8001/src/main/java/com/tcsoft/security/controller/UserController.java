package com.tcsoft.security.controller;

import com.tcsoft.security.dao.UserDao;
import com.tcsoft.security.entity.QueryConditionBean;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.entity.UserServiceBean;
import com.tcsoft.security.service.user.*;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WMY
 */
@RestController
public class UserController {
    @Resource
    private UserDeleteService userDeleteService;
    @Resource
    private UserRegisterService userRegisterService;
    @Resource
    private UserModifyService userModifyService;
    @Resource
    private UserQueryService userQueryService;

    @PostMapping("/user")
    public ResultData<String> userService(@RequestBody UserServiceBean userServiceBean,
                                  @RequestParam String type,
                                  Authentication authentication){
        if (type != null){
            switch (type) {
                case UserConstant.DELETE:
                    //删除操作,根据userId删除用户
                    if (userServiceBean.getUserId()==null){
                        return nullParameter();
                    }else {
                        int deleteUserId = userServiceBean.getUserId();
                        return userDeleteService.delete(deleteUserId, authentication);
                    }
                case UserConstant.CREATE:
                    //创建操作
                    if (userServiceBean.getGroupId()==null || userServiceBean.getRoleId()==null ||
                    userServiceBean.getUsername()== null || userServiceBean.getPassword()==null){
                        return nullParameter();
                    }else {
                        return userRegisterService.register(userServiceBean, authentication);
                    }
                case UserConstant.MODIFY:
                    //修改操作
                    if (userServiceBean.getUserId()==null){
                        return nullParameter();
                    }else {
                        return userModifyService.modify(userServiceBean, authentication);
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
    public ResultData<List<UserDao>> getUser(QueryConditionBean condition,
                                             Authentication authentication){
        return userQueryService.query(condition, authentication);
    }


    @GetMapping("/front/user")
    public ResultData<List<UserServiceBean>> frontGetUser(String username, Authentication authentication){
        if (username == null){
            return userQueryService.frontQuery(authentication);
        }else {
            return userQueryService.frontQueryByName(username, authentication);
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
