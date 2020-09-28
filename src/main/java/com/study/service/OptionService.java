package com.study.service;

import com.study.bean.Option;
import com.study.bean.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

/**
 * @author ZIKOR
 * @date 2020/9/26 9:16
 * @desc
 */
public interface OptionService {
    public List<Option> findOptionsByArticleId(@Param("id") int id);

    public int getTitleNum(@Param("id") int id);

    public List<String> findOptionValue(@Param("id") int id);

    public int updateOption(int id, String title, Model model);
}
