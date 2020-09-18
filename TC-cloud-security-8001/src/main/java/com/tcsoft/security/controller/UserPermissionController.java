package com.tcsoft.security.controller;


import com.tcsoft.security.dao.UserPermissionDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.permission.UserPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户授权API
 * @author WMY
 */
@RestController
public class UserPermissionController {

    @Resource
    private UserPermissionService permissionService;

    /**
     * 根据用户ID获取该用户所有的权限信息
     * @param userId
     * @return
     */
    @GetMapping("/permission")
    public ResultData<List<UserPermissionDao>> getUserPermission(@RequestParam("userId")Integer userId){
        return permissionService.queryByUserId(userId);
    }

    /**
     * 根据用户ID对他的权限进行增加，删除，修改
     * @param userId
     * @param list
     * @return
     */
    @PostMapping("/permission")
    public ResultData<String> modifyPermission(@RequestParam("userId")Integer userId,
                                               @RequestBody List<Integer> list){
        return permissionService.modifyByUserId(userId, list);
    }

}
