package com.exampro.mapper;

import com.exampro.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {
    /**
     * 查询所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAllUsers();

    /**
     * 通过用户名到对应的用户
     */
    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username") String username);

    /**
     * 插入新用户
     * @param newUser
     * @return
     */
    @Insert("INSERT INTO user (username, password, role) VALUES (#{username}, #{password}, #{role})")
    int insertNewUser(User newUser);

    int deleteByPrimaryKey(Integer userid);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}