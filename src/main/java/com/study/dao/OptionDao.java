package com.study.dao;

import com.study.bean.Article;
import com.study.bean.InsertOption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ZIKOR
 * @date 2020/9/24 14:37
 * @desc
 */
@Mapper
@Repository
public interface OptionDao {
    public int addOption(InsertOption option);
}
