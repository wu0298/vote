package com.study.service;

import com.study.bean.Article;
import com.study.bean.TempArticle;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:38
 * @desc
 */
public interface ArticleService {
    //public int getArticleTitle(String title);

    public int addArticle(TempArticle article);
}
