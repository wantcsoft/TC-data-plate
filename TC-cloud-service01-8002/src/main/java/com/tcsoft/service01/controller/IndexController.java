package com.tcsoft.service01.controller;


import com.tcsoft.service01.Mapper.UserMapper;
import com.tcsoft.service01.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author WMY
 */
@Slf4j
@Controller
@ResponseBody
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/login")
    public String login(@RequestParam("name")String userName, @RequestParam("password")String password, Model model){
        log.info("username = {}, password = {}", userName, password);
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户登录的数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(true);
        try {
            subject.login(token);
            return "index";
        }catch (UnknownAccountException e){
            log.error("用户名不存在");
            model.addAttribute("msg", "用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            log.error("密码错误");
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @GetMapping("/index")
    public String toInde(){
        return "这里是首页";
    }

    @GetMapping("/add")
    public String add(){
        return "添加用户";
    }

    @GetMapping("/delete")
    public String delete(){
        return "删除用户";
    }

    @GetMapping("/modify")
    public String modify(){
        return "修改用户";
    }

    @GetMapping("/query")
    public String query(){
        User user = userMapper.queryUserByName("admin");
        return user.getPassword();
    }
}
