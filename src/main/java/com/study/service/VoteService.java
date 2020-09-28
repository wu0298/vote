package com.study.service;

import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

/**
 * @author ZIKOR
 * @date 2020/9/27 9:47
 * @desc
 */
public interface VoteService {
    public int addVote(HashMap<String,Object> map);

    public int delVote(int id);
}
