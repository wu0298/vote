package com.study.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ZIKOR
 * @date 2020/9/24 9:45
 * @desc
 */
@Repository
@Mapper
public interface UserDao {
    public int registerUser(@Param("username") String username, @Param("password") String password);
}
