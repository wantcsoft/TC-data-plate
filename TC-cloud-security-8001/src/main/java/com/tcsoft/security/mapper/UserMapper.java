package com.tcsoft.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.security.dao.UserDao;
import org.apache.ibatis.annotations.Mapper;


/**
 * 数据库的mapper实现类
 * @author big_john
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDao> {

}
