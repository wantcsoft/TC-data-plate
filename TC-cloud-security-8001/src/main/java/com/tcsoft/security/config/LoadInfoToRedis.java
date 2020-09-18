package com.tcsoft.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tcsoft.security.dao.UserGroupDao;
import com.tcsoft.security.mapper.UserGroupMapper;
import com.tcsoft.security.utils.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目启动时将其他模块所需要的信息加载到redis中
 * @author WMY
 */
@Slf4j
@Component
public class LoadInfoToRedis {
    @Resource
    private UserGroupMapper groupMapper;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 启动方法
     */
    public void start() {
        loadGroup();
    }

    /**
     * 将群组信息加载到redis中
     */
    private void loadGroup() {
        List<UserGroupDao> list = groupMapper.selectList(null);
        Map<String, Object> map = new HashMap<>(list.size());
        for (UserGroupDao item : list) {
            ObjectMapper om = new ObjectMapper();
            try {
                String group = om.writeValueAsString(item);
                map.put("groupId="+item.getGroupId(), group);
            }catch (Exception e){
                log.error("UserGroup" + item.getGroupId() + "load fail " + e);
            }
        }
        try {
            redisUtil.hmset("UserGroup", map);
            log.info("UserGroup load success ");
        }catch (Exception e){
            log.error("UserGroup load fail " + e);
        }
    }

}
