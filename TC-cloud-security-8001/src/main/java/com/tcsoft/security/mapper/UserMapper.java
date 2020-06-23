package com.tcsoft.security.mapper;


import com.tcsoft.security.user.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * 数据库的mapper实现类
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where name = #{name};")
    User queryUserByName(String name);

    @Select("select * from user where id = #{id};")
    User queryUserById(String id);

    @Select("select * from user;")
    List<User> queryAll();

    @Insert("")
    boolean insertOne(User user);

    @Update("")
    boolean updateOne(User user);

    @Delete("")
    boolean deleteOne(String id);
}
