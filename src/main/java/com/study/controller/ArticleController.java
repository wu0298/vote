package com.study.controller;

import com.study.bean.Article;
import com.study.bean.Listing;
import com.study.bean.Result;
import com.study.bean.TempArticle;
import com.study.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.ElementType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/loadArticleList")
    public String loadArticleList(@RequestParam("title") String title,
                                  @RequestParam("page") int page,
                                  @RequestParam("del") String del,
                                  HttpServletRequest request,
                                  Model model){
        HttpSession session = request.getSession();

        if (page==0){
            page = 1;
        }
        List<Listing> list = articleService.loadArticleList(title,page);

        session.removeAttribute("del");
        session.setAttribute("del",del);

        model.addAttribute("title",title);
        model.addAttribute("page",page);
        model.addAttribute("list",list);
        
        return "admin/tpList";
    }

    @RequestMapping("updateArticle")
    public String updateArticle(Model model,HttpServletRequest request){
        List<Listing> list = articleService.loadArticleList("",1);
        HttpSession session = request.getSession();

        session.setAttribute("del","d");
        model.addAttribute("list",list);

        return "admin/tpList";
    }

    @RequestMapping("searchArticle")
    public String searchArticle(HttpServletRequest request,
                                Model model){
        String title = request.getParameter("search");
        String del = request.getParameter("del");
        int page = 1;
        List<Listing> list = articleService.loadArticleList(title,page);


        model.addAttribute("title",title);
        model.addAttribute("page",page);
        model.addAttribute("list",list);

        return "admin/tpList";
    }
}
