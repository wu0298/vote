package com.study.service;

import com.study.bean.Article;
import com.study.bean.Option;
import com.study.bean.Options;
import com.study.dao.ArticleDao;
import com.study.dao.OptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author ZIKOR
 * @date 2020/9/26 9:16
 * @desc
 */
@Service
public class OptionServiceImpl implements OptionService {

    @Autowired
    private OptionDao optionDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public List<Option> findOptionsByArticleId(int id) {
        List<Options> list = optionDao.findOptionsByArticleId(id);

        List<Option> options=new ArrayList<Option>();
        for(Options op:list){
            Option option = new Option();
            int num = optionDao.findVoteNum(op.getOptionvalue());
            option.setNum(num);
            option.setOption(op.getOptionvalue());
            options.add(option);
        }

        return options;
    }

    @Override
    public int getTitleNum(int id) {
        return optionDao.getTitleNum(id);
    }

    @Override
    public List<String> findOptionValue(int id) {
        return optionDao.findOptionValue(id);
    }

    @Override
    public int updateOption(int id, String title, Model model) {
        List<String> optionValues = optionDao.findOptionValue(id);
        Article article = articleDao.getArticle(title);
        int typ = article.getType();

        if (optionValues.size()>0){
            request.setAttribute("typ", typ);
            model.addAttribute("title", title);
            model.addAttribute("list", optionValues);
            return 1;
        }else return 0;

    }
}
