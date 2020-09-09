package com.tcsoft.security.controller;


import com.tcsoft.security.dao.UserAuthorityDao;
import com.tcsoft.security.dao.UserPermissionDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.permission.UserPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WMY
 */
@RestController
public class UserPermissionController {

    @Resource
    private UserPermissionService permissionService;

    @GetMapping("/permission")
    public ResultData<List<UserPermissionDao>> getUserPermission(@RequestParam("userId")Integer userId){
        return permissionService.queryByUserId(userId);
    }

    @PostMapping("/permission")
    public ResultData<String> modifyPermission(@RequestParam("userId")Integer userId,
                                               @RequestBody List<Integer> list){
        return permissionService.modifyByUserId(userId, list);
    }

}
