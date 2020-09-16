package com.tcsoft.security.controller;


import com.tcsoft.security.dao.UserRoleDao;
import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.role.UserRoleQueryService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author big_john
 */
@RestController
public class UserRoleController {

    @Resource
    private UserRoleQueryService userRoleQueryService;

    @GetMapping("/getRole")
    public ResultData<List<UserRoleDao>> getRole(Authentication authentication){
        JwtUser user = (JwtUser) authentication.getPrincipal();
        String role = "";
        for (GrantedAuthority i : user.getAuthorities()){
            role = i.getAuthority();
        }
        return userRoleQueryService.queryAllRole(role, user.getGroupId());
    }

}
