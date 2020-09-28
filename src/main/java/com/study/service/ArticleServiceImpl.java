package com.study.service;

import com.study.bean.*;
import com.study.dao.ArticleDao;
import com.study.dao.OptionDao;
import com.study.dao.UserDao;
import com.study.dao.VoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private UserDao userDao;

    @Autowired
    private VoteDao voteDao;

    @Autowired
    private HttpServletRequest request;

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

    @Override
    public List<Listing> loadArticleList(String title,int page) {
        page = (page - 1) * 2;
        HttpSession session = request.getSession();
        int userid = userDao.getUserId(session.getAttribute("username").toString());
        List<Map<String,Object>> list = articleDao.loadArticleList(title,page);
        List<Map<String,Object>> list2 = articleDao.loadArticleList2(title);
        List<Listing> viewlist=new ArrayList<>();

        for (int i=0;i<list.size();i++){
            if (i<list2.size()){
                Listing listing = new Listing();
                listing.setId(Integer.valueOf(list.get(i).get("id").toString()));
                listing.setVoteNum(Integer.valueOf(list2.get(i).get("num").toString()));
                listing.setTitle(list.get(i).get("title").toString());
                listing.setOptionNum(Integer.valueOf(list.get(i).get("num").toString()));

                int articleid = Integer.valueOf(list.get(i).get("id").toString());
                int k = voteDao.isUserVote(articleid,userid);
                listing.setVote(k>0?true:false);

                viewlist.add(listing);
            }else{

                Listing listing = new Listing();
                listing.setId(Integer.valueOf(list.get(i).get("id").toString()));
                listing.setVoteNum(0);
                listing.setTitle(list.get(i).get("title").toString());
                listing.setOptionNum(Integer.valueOf(list.get(i).get("num").toString()));

                int articleid = Integer.valueOf(list.get(i).get("id").toString());
                int k = voteDao.isUserVote(articleid,userid);
                listing.setVote(k>0?true:false);

                viewlist.add(listing);
            }
        }
        return viewlist;
    }

    @Override
    public int findType(int id) {
        return articleDao.findType(id);
    }
}
