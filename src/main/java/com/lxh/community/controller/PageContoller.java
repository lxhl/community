package com.lxh.community.controller;

import com.lxh.community.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author LXH
 * @date 2019/8/29 -9:41
 */
public class PageContoller {
    @Autowired
    private QuestionMapper questionMapper;
    public String pageCount(){
        Integer count = questionMapper.count();
        return null;
    }
}
