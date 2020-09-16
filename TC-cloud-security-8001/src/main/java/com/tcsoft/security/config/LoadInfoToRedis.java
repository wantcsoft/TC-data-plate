package com.tcsoft.security.config;

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
 * @author WMY
 */
@Slf4j
@Component
public class LoadInfoToRedis {
    @Resource
    private UserGroupMapper groupMapper;

    @Resource
    private RedisUtil redisUtil;

    public void start(){
        loadGroup();
    }

    private void loadGroup(){
        List<UserGroupDao> list = groupMapper.selectList(null);
        Map<String, Object> map = new HashMap<>(list.size());
        for (UserGroupDao group : list) {
            map.put("groupId="+group.getGroupId(), group);
        }
        try {
            redisUtil.hmset("UserGroup", map);
            log.info("UserGroup load success ");
        }catch (Exception e){
            log.error("UserGroup load fail " + e);
        }
    }

}
