package com.study.bean;

/**
 * @author ZIKOR
 * @date 2020/9/25 20:37
 * @desc
 */
public class Vote {
    private int id;
    private int articleid;
    private int optionid;
    private int voterid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticleid() {
        return articleid;
    }

    public void setArticleid(int articleid) {
        this.articleid = articleid;
    }

    public int getOptionid() {
        return optionid;
    }

    public void setOptionid(int optionid) {
        this.optionid = optionid;
    }

    public int getVoterid() {
        return voterid;
    }

    public void setVoterid(int voterid) {
        this.voterid = voterid;
    }
}
