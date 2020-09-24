package com.study.controller;

import com.study.bean.Article;
import com.study.bean.Result;
import com.study.bean.TempArticle;
import com.study.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.ElementType;
import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:40
 * @desc
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/addArticle")
    @ResponseBody
    public Result addArticle(@RequestBody TempArticle tempArticle){
        int i = articleService.addArticle(tempArticle);
        if (i == 2){
            return new Result(400,"该投票主题已存在");
        }else if (i != 0){
            return new Result(200,"添加成功");
        }else{
            return new Result(400,"添加失败");
        }
    }
}
