package com.tcsoft.security.controller;


import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.role.UserRoleQueryService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author big_john
 */
@RestController
public class UserRoleController {

    @Resource
    private UserRoleQueryService userRoleQueryService;

    @GetMapping("/role")
    public ResultData<List<UserRoleDao>> getRole(Authentication authentication){
        ResultData<List<UserRoleDao>> resultData = new ResultData<>();
        try{
            JwtUser user = (JwtUser) authentication.getPrincipal();
            return userRoleQueryService.queryAllRole(user.getUsername(), resultData);
        }catch (Exception e){
            resultData.setCode(402);
            resultData.setMessage("操作失败");
            return resultData;
        }
    }

}
