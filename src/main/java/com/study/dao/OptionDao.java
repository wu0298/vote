package com.study.dao;

import com.study.bean.Article;
import com.study.bean.ArticleVote;
import com.study.bean.InsertOption;
import com.study.bean.Options;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:37
 * @desc
 */
@Mapper
@Repository
public interface OptionDao {
    public int addOption(InsertOption option);

    public ArticleVote getArticleVote(@Param("id") int id);

    public List<Options> findOptionsByArticleId(@Param("id") int id);

    public List<String> findOptionValue(@Param("id") int id);

    public int findVoteNum(@Param("optionvalue") String optionvalue);

    public int getTitleNum(@Param("id") int id);

    public int getOptionId(@Param("optionvalue") String optionvalue);

    public int deleteOption(@Param("articleid") int id);
}
