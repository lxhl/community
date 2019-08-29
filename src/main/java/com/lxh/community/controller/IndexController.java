package com.lxh.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxh.community.dto.QuestionDTO;
import com.lxh.community.mapper.QuestionDTOMapper;
import com.lxh.community.mapper.QuestionMapper;
import com.lxh.community.model.Question;
import com.lxh.community.service.QuestionService;
import freemarker.ext.beans.StringModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author LXH
 * @date 2019/8/27 -22:16
 */
@Controller
public class IndexController {
    @Autowired
    private QuestionService questionService;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuestionDTOMapper questionDTOMapper;
    @GetMapping("/")
    public String index(@RequestParam(name = "pageNumber",defaultValue = "1") String pageNumber,
                        @RequestParam(name = "pageSize",defaultValue = "5") String pageSize,
                        Model model){
        PageHelper.startPage(Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
        PageInfo<QuestionDTO> pageInfo=new PageInfo<>(questionDTOMapper.selectList(),5);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
}
