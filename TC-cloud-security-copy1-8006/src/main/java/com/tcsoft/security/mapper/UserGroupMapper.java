package com.tcsoft.security.mapper;

import com.tcsoft.security.dao.UserGroupDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author big_john
 */
@Mapper
public interface UserGroupMapper {

    /**
     * 获取所有的组的信息
     * @return
     */
    @Select("select * from user_group;")
    List<UserGroupDao> queryAllGroup();

    /**
     * 根据groupId查询用户组的信息
     * @param groupId
     * @return
     */
    @Select("select * from user_group where groupId = #{groupId};")
    List<UserGroupDao> queryGroupById(@Param("groupId") Integer groupId);

    /**
     * 根据组描述，查询组的信息
     * @param groupDescription
     * @return
     */
    @Select("select * from user_group where groupDescription = #{groupDescription};")
    UserGroupDao queryGroupByDescription(@Param("groupDescription")String groupDescription);
}
