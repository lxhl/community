package com.lxh.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxh.community.dto.QuestionDTO;
import com.lxh.community.mapper.QuestionDTOMapper;
import com.lxh.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LXH
 * @date 2019/8/29 -7:29
 */
@Controller
@RequestMapping("/profile")
public class profileController {
    @Autowired
    private QuestionDTOMapper questionDTOMapper;
    @GetMapping("/question")
    public String question(@RequestParam(value = "pageNumber",defaultValue = "1") String pageNumber,
                           @RequestParam(value = "pageSize",defaultValue = "5") String pageSize,
                           Model model, HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        PageHelper.startPage(Integer.parseInt(pageNumber),Integer.parseInt(pageSize));
        PageInfo<QuestionDTO> pageInfo=new PageInfo<>(questionDTOMapper.selectListByAccountId(user.getAccountId()),5);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("active", "question");
        model.addAttribute("activeName", "我的问题");
        return "profile";
    }


    @GetMapping("/reply")
    public String reply(Model model){
        model.addAttribute("active", "reply");
        model.addAttribute("activeName", "我的回复");
        return "profile";
    }
}
