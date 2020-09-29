package com.study.service;

import com.study.bean.Article;
import com.study.bean.Listing;
import com.study.bean.TempArticle;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:38
 * @desc
 */
public interface ArticleService {
    //public int getArticleTitle(String title);

    public int addArticle(TempArticle article);

    public List<Listing> loadArticleList(String title,int page);

    public int findType(@Param("id") int id);

    public List<HashMap<String,Object>> heatTitle();
}
