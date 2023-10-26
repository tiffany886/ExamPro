package com.exampro.mapper;

import com.exampro.model.User;
import org.apache.ibatis.annotations.*;
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
    @Insert("INSERT INTO user (username, password, roleid) VALUES (#{username}, #{password}, #{roleid})")
    int insertNewUser(User newUser);

    /**
     * 通过用户名id到对应的用户
     */
    @Select("select * from user where UserID = #{userid}")
    User findByUserID(@Param("userid") Integer userid);

    /**
     * 通过用户id修改用户密码
     * @param newPassword
     * @param userid
     * @return
     */
    @Update("update user set Password = #{newPassword} where UserID = #{userid}")
    int updateUserPwdByUserId(@Param("newPassword") String newPassword, @Param("userid") Integer userid);

    /**
     * 通过用户id修改用户名
     * @param newUsername
     * @param userid
     * @return
     */
    @Update("update user set Username = #{newUsername} where UserID = #{userid}")
    int updateUsernameByUserId(@Param("newUsername") String newUsername, @Param("userid") Integer userid);

}