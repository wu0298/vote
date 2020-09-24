package com.study.bean;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/24 15:16
 * @desc
 */
public class TempArticle {
    private String title;
    private Integer typ;
    private List<String> option;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTyp() {
        return typ;
    }

    public void setTyp(Integer typ) {
        this.typ = typ;
    }

    public List<String> getOption() {
        return option;
    }

    public void setOption(List<String> option) {
        this.option = option;
    }
}
