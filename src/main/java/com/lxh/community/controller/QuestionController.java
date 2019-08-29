package com.lxh.community.controller;

import com.lxh.community.dto.QuestionDTO;
import com.lxh.community.mapper.QuestionDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author LXH
 * @date 2019/8/29 -14:26
 */
@Controller
public class QuestionController {
    @Autowired
    private QuestionDTOMapper questionDTOMapper;
    @GetMapping("/question/{id}")
    public String toQuestion(@PathVariable(value = "id") String id,
                             Model model){
        QuestionDTO questionDTO = questionDTOMapper.selectByQuestionId(Integer.parseInt(id));
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
