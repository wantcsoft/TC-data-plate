package com.tcsoft.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author WMY
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        System.out.println("1111111111111111111");
        return "1111111111111111111111";
    }
}
