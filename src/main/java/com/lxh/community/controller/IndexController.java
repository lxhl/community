package com.lxh.community.controller;

import com.lxh.community.dto.QuestionDTO;
import com.lxh.community.mapper.QuestionMapper;
import com.lxh.community.model.Question;
import com.lxh.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    @GetMapping("/")
    public String index(Model model){
        List<QuestionDTO> questionDTOList = questionService.list();
        model.addAttribute("list",questionDTOList);
        return "index";
    }
}
