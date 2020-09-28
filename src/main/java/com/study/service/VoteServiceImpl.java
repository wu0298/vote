package com.study.service;

import com.alibaba.fastjson.JSONObject;
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

/**
 * @author ZIKOR
 * @date 2020/9/27 9:48
 * @desc
 */
@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteDao voteDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private OptionDao optionDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    //public int addVote(int articleid, String title, String type) {
    public int addVote(HashMap<String,Object> map) {
        int articleid = Integer.valueOf(String.valueOf(map.get("id")));
        String type = String.valueOf(map.get("type"));
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("username").toString());
        int userid = userDao.getUserId(session.getAttribute("username").toString());

        if (type.equals("1")){
            String option = String.valueOf(map.get("radio"));
            int optionid = optionDao.getOptionId(option);
            return voteDao.addVote(articleid,optionid,userid);
        }else{
            List<String> list = (List<String>) map.get("chbox");
            int i = 0;
            for (String str:list){
                int optionid = optionDao.getOptionId(str);
                i = voteDao.addVote(articleid,optionid,userid);
                if (i!=1){
                    return 0;
                }
            }
            return i;
        }
    }

    @Override
    public int delVote(int id) {
        int i = voteDao.deleteVote(id);
        int k = optionDao.deleteOption(id);
        int j = articleDao.deleteArticle(id);

        if (i > 0 && k > 0 && j > 0){
            return 1;
        }
        return 0;
    }
}
