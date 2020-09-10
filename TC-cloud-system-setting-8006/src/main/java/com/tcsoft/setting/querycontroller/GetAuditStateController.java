package com.tcsoft.setting.querycontroller;


import com.tcsoft.setting.utils.RedisUtil;
import com.tcsoft.setting.viewmodel.AuditStateViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author WMY
 */
@RestController
public class GetAuditStateController {

    @Resource
    private RedisUtil redisUtil;

    @GetMapping("/test")
    public String test(){
        Map<Object, Object> auditState = redisUtil.hmget("AuditState");
        System.out.println(auditState);
        return "hello";
    }

}
