package com.study.bean;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/25 20:36
 * @desc
 */
public class ArticleVote {
    private int id;
    private String title;
    private List<Vote> listVote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Vote> getListVote() {
        return listVote;
    }

    public void setListVote(List<Vote> listVote) {
        this.listVote = listVote;
    }
}
