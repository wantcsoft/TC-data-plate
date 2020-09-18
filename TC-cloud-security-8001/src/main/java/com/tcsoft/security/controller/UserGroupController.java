package com.tcsoft.security.controller;

import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.group.UserGroupService;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户组信息api
 * @author big_john
 */
@RestController
public class UserGroupController {

    @Resource
    private UserGroupService groupService;

    /**
     * 获取自己能看到的所有组信息
     * @param authentication
     * @return
     */
    @GetMapping("/group")
    public ResultData<List<UserGroupDao>> getUserGroups(Authentication authentication){
        JwtUser user = (JwtUser) authentication.getPrincipal();
        String role = "";
        for (GrantedAuthority i : user.getAuthorities()){
            role = i.getAuthority();
        }
        return groupService.getUserGroup(role, user.getGroupId());
    }

    /**
     * 对组信息进行增加，删除，修改
     * @param dao
     * @param type
     * @return
     */
    @PostMapping("/group")
    public ResultData<String> group(@RequestBody UserGroupDao dao,
                                    @RequestParam String type){
        switch (type){
            case UserConstant.CREATE:
                return groupService.createGroup(dao);
            case UserConstant.DELETE:
                return groupService.deleteGroup(dao);
            case UserConstant.MODIFY:
                return groupService.modifyGroup(dao);
            default:
                ResultData<String> resultData = new ResultData<>();
                resultData.setCode(403);
                resultData.setMessage("操作失败");
                return resultData;
        }
    }
}
