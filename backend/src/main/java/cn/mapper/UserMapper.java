package cn.mapper;

import cn.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM user WHERE user_name = #{username}")
    List<User> selectOneCustom(@Param("username") String username);

    @Select("SELECT * FROM user WHERE email = #{email}")
    List<User> selectOneEmail(@Param("email") String email);

    @Insert("INSERT INTO user (user_name, email, password) VALUES (#{username}, #{email}, #{password})")
    void insertUser(@Param("username") String username, @Param("email") String email,
            @Param("password") String password);

    @Update("UPDATE user SET user_name = #{newUsername} WHERE user_name = #{username}")
    void updateUsername(@Param("username") String username, @Param("newUsername") String newUsername);

    @Update("UPDATE user SET password = #{password} WHERE user_name = #{username}")
    void updatePassword(@Param("username") String username, @Param("password") String password);

    @Update("UPDATE user SET email = #{email} WHERE user_name = #{username}")
    void updateEmail(@Param("username") String username, @Param("email") String email);

    @Update("UPDATE user SET last_login_time = #{lastLoginTime} WHERE user_name = #{username}")
    void updateLastLoginTime(@Param("username") String username, @Param("lastLoginTime") Timestamp lastLoginTime);

    @Delete("DELETE FROM user WHERE user_name = #{username}")
    void deleteUser(@Param("username") String username);

    @Delete("DELETE FROM user")
    void deleteAllUser();
}
