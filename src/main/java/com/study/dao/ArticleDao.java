package com.study.dao;

import com.study.bean.Article;
import com.study.bean.TempArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:36
 * @desc
 */
@Mapper
@Repository
public interface ArticleDao {
    //public int getArticleTitle(@Param("title") String title);

    public int addArticle(TempArticle article);

    public Article getArticle(@Param("title") String title);

    public List<Map<String,Object>> loadArticleList(@Param("title") String title,@Param("page") int page);

    public List<Map<String,Object>> loadArticleList2(@Param("title") String title);

    public int findType(@Param("id") int id);

    public int deleteArticle(@Param("id") int id);
}
