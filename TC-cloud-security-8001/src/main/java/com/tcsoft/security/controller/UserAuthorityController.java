package com.tcsoft.security.controller;


import com.tcsoft.security.dao.UserAuthorityDao;
import com.tcsoft.security.entity.ResultData;
import com.tcsoft.security.service.authority.UserAuthorityService;
import com.tcsoft.security.utils.UserConstant;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author WMY
 */
@RestController
public class UserAuthorityController {

    @Resource
    private UserAuthorityService authorityService;

    @GetMapping("/authority")
    public ResultData<List<UserAuthorityDao>> getUserAuthority(){
        return authorityService.queryAll();
    }

    @PostMapping("/authority")
    public ResultData<String> userAuthority(@RequestBody UserAuthorityDao dao,
                                            @RequestParam String type){
        switch (type){
            case UserConstant.CREATE:
                return authorityService.createAuthority(dao);
            case UserConstant.DELETE:
                return authorityService.deleteAuthority(dao);
            case UserConstant.MODIFY:
                return authorityService.modifyAuthority(dao);
            default:
                ResultData<String> resultData = new ResultData<>();
                resultData.setCode(403);
                resultData.setMessage("操作失败");
                return resultData;
        }
    }
}
