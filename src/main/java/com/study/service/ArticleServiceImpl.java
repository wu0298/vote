package com.study.service;

import com.study.bean.Article;
import com.study.bean.InsertOption;
import com.study.bean.TempArticle;
import com.study.dao.ArticleDao;
import com.study.dao.OptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:39
 * @desc
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private OptionDao optionDao;

    //@Override
    //public int getArticleTitle(String title) {
    //    return articleDao.getArticleTitle(title);
    //}

    @Override
    public int addArticle(TempArticle tempArticle) {
        Article article = articleDao.getArticle(tempArticle.getTitle());
        InsertOption option = new InsertOption();
        if (article != null){
            return 2; //已经存在了主题
        }else{
            int i = articleDao.addArticle(tempArticle);
            if (i>0){
                article = articleDao.getArticle(tempArticle.getTitle());
                option.setArticleid(article.getId());
                option.setOptionvalue(tempArticle.getOption());
                int k = optionDao.addOption(option);
                if (k > 0){
                    return 1; //添加成功
                }else {
                    return 3; //添加投票选项失败
                }
            }

            return 0; //添加主题失败
        }
    }
}
