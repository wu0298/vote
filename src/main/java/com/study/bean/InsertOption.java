package com.study.bean;

import java.util.List;

/**
 * @author ZIKOR
 * @date 2020/9/24 19:04
 * @desc
 */
public class InsertOption {
    private List<String> optionvalue;
    private int articleid;

    public List<String> getOptionvalue() {
        return optionvalue;
    }

    public void setOptionvalue(List<String> optionvalue) {
        this.optionvalue = optionvalue;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }
}
