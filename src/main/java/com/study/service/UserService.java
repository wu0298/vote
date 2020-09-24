package com.study.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author ZIKOR
 * @date 2020/9/24 9:46
 * @desc
 */
public interface UserService {
    public int registerUser(@Param("username") String username, @Param("password") String password);
}
