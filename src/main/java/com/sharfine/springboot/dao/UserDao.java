package com.sharfine.springboot.dao;

import com.sharfine.springboot.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") Integer id);
    @Insert("insert into user(id, name, age) values(null, #{name}, #{age})")
    void insert(@Param("name") String name, @Param("age") Integer age);
}
