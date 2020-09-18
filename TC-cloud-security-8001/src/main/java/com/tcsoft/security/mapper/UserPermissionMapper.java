package com.tcsoft.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tcsoft.security.dao.UserPermissionDao;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 数据库操作模型
 * @author WMY
 */
public interface UserPermissionMapper extends BaseMapper<UserPermissionDao> {
    /**
     * 通过userId查询出该用户所有的权限
     * @param userId
     * @return
     */
    @Select("select UserAuthority.Authority\n" +
            "from UserPermission, UserAuthority\n" +
            "where UserPermission.AuthorityID = UserAuthority.AuthorityID;")
    List<String> selectAuthorityByUserId(@Param("userId")Integer userId);

    /**
     * 通过userId查询出该用户所有的权限ID
     * @param userId
     * @return
     */
    @Select("select AuthorityID\n" +
            "from UserPermission\n" +
            "where UserID = #{userId};")
    List<UserPermissionDao> selectPermissionByUserId(@Param("userId")Integer userId);

    /**
     * 根据userId删除用户信息
     * @param userId
     * @return
     */
    @Delete("delete from UserPermission\n" +
            "where UserID = #{userId};")
    boolean deletePermissionByUserId(@Param("userId")Integer userId);

    /**
     * 插入一条记录
     * @param userId
     * @param authorityId
     * @return
     */
    @Insert("INSERT INTO UserPermission (UserID, AuthorityID)\n" +
            "VALUES (#{userId}, #{authorityId});")
    boolean insertPermission(@Param("userId")Integer userId, @Param("authorityId")Integer authorityId);

}
