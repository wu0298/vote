package com.study.controller;

import com.study.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ZIKOR
 * @date 2020/9/28 8:56
 * @desc
 */
@Controller
public class VoteController {

    @Autowired
    private VoteService voteService;

    @RequestMapping("delVote")
    public String delVote(@RequestParam("id") int id){
        int i = voteService.delVote(id);
            return "admin/index";
    }
}
