package com.tcsoft.security.controller;


import com.tcsoft.security.entity.JwtUser;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.UserAuthorityService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author big_john
 */
@RestController
public class UserAuthorityController {

    @Resource
    private UserAuthorityService userAuthorityService;

    @GetMapping("/getAuthority")
    public ResultData getAuthority(Authentication authentication){
        ResultData<String> resultData = new ResultData<>();
        if (authentication == null || authentication.getPrincipal() == null) {
            resultData.setCode(402);
            resultData.setMessage("操作失败");
            return resultData;
        }
        try{
            JwtUser user = (JwtUser) authentication.getPrincipal();
            String username = user.getUsername();
            return userAuthorityService.getUserAuthority(username);
        }catch (Exception e){
            resultData.setCode(402);
            resultData.setMessage("操作失败");
            return resultData;
        }
    }
}
