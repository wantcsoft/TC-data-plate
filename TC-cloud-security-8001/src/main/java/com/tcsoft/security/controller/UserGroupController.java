package com.tcsoft.security.controller;

import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.group.UserGroupService;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author big_john
 */
@RestController
public class UserGroupController {

    @Resource
    private UserGroupService groupService;

    /**
     * 获取组信息
     * @param authentication
     * @return
     */
    @GetMapping("/group")
    public ResultData<List<UserGroupDao>> getUserGroups(Authentication authentication){
        JwtUser user = (JwtUser) authentication.getPrincipal();
        return groupService.getUserGroup(user.getUsername());
    }

    @PostMapping("/group")
    public ResultData<String> group(@RequestBody UserGroupDao userGroupDao,
                                    @RequestParam String type, Authentication authentication){
        if (userGroupDao == null){
            ResultData<String> resultData = new ResultData<>();
            resultData.setCode(403);
            resultData.setMessage("操作失败");
            return resultData;
        }
        switch (type){
            case UserConstant.CREATE:
                return groupService.createGroup(userGroupDao);
            case UserConstant.DELETE:
                return groupService.deleteGroup(userGroupDao);
            case UserConstant.MODIFY:
                System.out.println(authentication.getAuthorities().toString());
                return groupService.modifyGroup(userGroupDao);
            default:
                ResultData<String> resultData = new ResultData<>();
                resultData.setCode(403);
                resultData.setMessage("操作失败");
                return resultData;
        }
    }
}
