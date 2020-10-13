package com.tcsoft.setting.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcsoft.setting.entity.JwtUser;
import com.tcsoft.setting.entity.UserGroupDao;
import com.tcsoft.setting.utils.JwtTokenUtil;
import com.tcsoft.setting.utils.RedisUtil;
import com.tcsoft.setting.viewmodel.HospitalInfoViewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

/**
 * 自定义拦截器
 * @author WMY
 */
@Slf4j
public class SettingFilter implements HandlerInterceptor {

    @Resource
    private RedisUtil redisUtil;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    private static final String TOKEN_HEAD = "Bearer ";
    private static final String SYSTEM_GROUP = "system";
    private static final HashSet<String> SETTING_URLS = new HashSet<>(
            Arrays.asList(new String[]{
                    "/setting/actionCode", "/setting/ageType",
                    "/setting/instrumentGroup", "/setting/instrumentType",
                    "/setting/patientType", "/setting/prepLinkAbortCode",
                    "/setting/prepLinkErrorCode", "/setting/resultRange",
                    "/setting/resultUnit", "/setting/ruleGroup",
                    "/setting/sampleType", "/setting/testItemType",
                    "/setting/testType", "/setting/chemistryContrast",
                    "/setting/comparisonInfo", "/setting/instrument",
                    "/setting/lotSet", "/setting/material",
                    "/setting/rule", "/setting/testItemDeltaCheck",
                    "/setting/testItemGroup", "/setting/testItemGroupItem",
                    "/setting/testItemInfo"}));

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization").substring(TOKEN_HEAD.length());
        JwtUser jwtUser = jwtTokenUtil.getJwtUser(token);
        String uri = request.getRequestURI();
        log.info("{}访问了{}, method = {}", jwtUser.getUsername(), uri, request.getMethod());
        String value = (String) redisUtil.hmget("UserGroup").get("groupId=" + jwtUser.getGroupId());
        ObjectMapper om = new ObjectMapper();
        UserGroupDao groupDao = om.readValue(value, UserGroupDao.class);
        int queryHospitalId = 0;
        if (SETTING_URLS.contains(uri)){
            if (!SYSTEM_GROUP.equals(groupDao.getGroup())){
                if ("GET".equals(request.getMethod())){
                    queryHospitalId = Integer.parseInt(request.getParameter("hospitalId"));
                }else if ("POST".equals(request.getMethod())){
                    BufferedReader reader = request.getReader();
                    Map<String, Double> params = om.readValue(reader, Map.class);
                    queryHospitalId = params.get("hospitalId").intValue();
                }
                log.info("GET请求获取信息，hospitalId = {}", queryHospitalId);
                if (queryHospitalId == 0) {
                    return false;
                }
                HospitalInfoViewModel hospitalInfo = (HospitalInfoViewModel) redisUtil
                        .hmget("HospitalInfo:hospitalId").get("hospitalId=" + queryHospitalId);
                if (!hospitalInfo.getHospitalName().equals(groupDao.getGroupDescription())){
                    log.info("所在医院和访问医院不统一");
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json");
                    response.getWriter().println("{\"code\":403,\"message\":\"你没有权限访问\",\"data\":\"\"}");
                    response.getWriter().flush();
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("执行完方法之后进执行(Controller方法调用之后)，但是此时还没进行视图渲染");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("整个请求都处理完咯，DispatcherServlet也渲染了对应的视图咯，此时我可以做一些清理的工作了");
    }

}
