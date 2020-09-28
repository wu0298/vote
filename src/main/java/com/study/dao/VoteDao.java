package com.study.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ZIKOR
 * @date 2020/9/26 14:28
 * @desc
 */
@Mapper
@Repository
public interface VoteDao {
    public int addVote(@Param("articleid") int articleid,@Param("optionid") int optionid,
                       @Param("voterid") int voterid);

    public int deleteVote(@Param("articleid") int id);

    public int isUserVote(@Param("articleid") int articleid,
                          @Param("userid") int userid);
}
