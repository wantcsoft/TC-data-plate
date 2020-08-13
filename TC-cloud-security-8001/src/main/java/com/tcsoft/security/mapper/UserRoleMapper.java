package com.tcsoft.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.security.dao.UserRoleDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author big_john
 */
@Mapper
public interface UserRoleMapper extends BaseMapper<UserRoleDao> {

}
