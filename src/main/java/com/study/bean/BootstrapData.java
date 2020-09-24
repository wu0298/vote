package com.study.bean;

/**
 * @author ZIKOR
 * @date 2020/9/23 16:43
 * @desc
 */
public class BootstrapData<T> {
    private Integer count;
    private T       data;

    public BootstrapData() {
    }

    public BootstrapData(Integer count, T data) {
        this.count = count;
        this.data = data;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
