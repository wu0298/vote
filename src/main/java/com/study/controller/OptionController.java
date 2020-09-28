package com.study.controller;

import com.study.bean.Option;
import com.study.bean.Options;
import com.study.bean.Result;
import com.study.service.ArticleService;
import com.study.service.OptionService;
import com.study.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZIKOR
 * @date 2020/9/26 9:19
 * @desc
 */
@Controller
public class OptionController {

    @Autowired
    private OptionService optionService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private VoteService voteService;

    @RequestMapping("lookVote")
    public String getVote(@RequestParam("title") String title,
                          @RequestParam("id") int id,
                          @RequestParam("optionNum") int optionNum,
                          @RequestParam("voteNum") int voteNum,
                          Model model){
        List<Option> list = optionService.findOptionsByArticleId(id);
        int titleNum = optionService.getTitleNum(id);

        model.addAttribute("optionNum",optionNum);
        model.addAttribute("voteNum",voteNum);
        model.addAttribute("options",list);
        model.addAttribute("titleNum",titleNum);
        model.addAttribute("title",title);

        return "admin/cktp";
    }

    @RequestMapping("/selectVote")
    public String selectVote(@RequestParam("title") String title,
                             @RequestParam("optionNum") String optionNum,
                             @RequestParam("voteNum") String voteNum,
                             @RequestParam("id") int id,
                             Model model){

        List<String> list = optionService.findOptionValue(id);
        int type = articleService.findType(id);

        model.addAttribute("id",id);
        model.addAttribute("title", title);
        model.addAttribute("optionNum", optionNum);
        model.addAttribute("voteNum", voteNum);
        model.addAttribute("type", type);
        model.addAttribute("optionList", list);

        return "admin/cytp";
    }

    @RequestMapping("/addVote")
    @ResponseBody
    public Result addVote(@RequestBody HashMap<String,Object> map){
        System.out.println(map);

        int i = voteService.addVote(map);
        //int i = voteService.addVote(id,title,type);
        if (i==1){
            return new Result(200,"投票成功");
        }else {
            return new Result(400,"投票失败");
        }
    }

    @RequestMapping("updateOption")
    public String updateOption(@RequestParam("id") int id,
                               @RequestParam("title") String title,
                               Model model){
        int i = optionService.updateOption(id,title,model);

        return i == 1 ? "admin/change" : "admin/index";
    }
}
