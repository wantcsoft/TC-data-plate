package com.tcsoft.security.controller;

import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.group.UserGroupService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author big_john
 */
@RestController
public class UserGroupController {

    @Resource
    private UserGroupService groupService;

    @GetMapping("/getGroups")
    public ResultData<List<UserGroupDao>> getUserGroups(Authentication authentication){
        ResultData<List<UserGroupDao>> resultData = new ResultData<>();
        if (authentication == null || authentication.getPrincipal() == null) {
            resultData.setCode(402);
            resultData.setMessage("操作失败");
            return resultData;
        }
        try{
            JwtUser user = (JwtUser) authentication.getPrincipal();
            return groupService.getUserGroup(user.getUsername(), resultData);
        }catch (Exception e){
            resultData.setCode(402);
            resultData.setMessage("操作失败");
            return resultData;
        }
    }
}
