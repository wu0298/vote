package com.study.bean;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:31
 * @desc
 */
public class Article {
    private int id;
    private String title;
    private int type;
    private String createtime;

    public Article() {
    }

    public Article(String title, int type) {
        this.title = title;
        this.type = type;
    }

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
}
