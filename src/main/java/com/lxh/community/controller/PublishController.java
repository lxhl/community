package com.lxh.community.controller;

import com.lxh.community.mapper.QuestionMapper;
import com.lxh.community.model.Question;
import com.lxh.community.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author LXH
 * @date 2019/8/28 -15:42
 */
@Controller
public class PublishController {
    @Autowired
    private QuestionMapper questionMapper;
    @PostMapping("/publish")
    public String doPublish (Question question, HttpServletRequest request, Model model){
        String title = question.getTitle();
        String tag = question.getTag();
        String description = question.getDescription();
        model.addAttribute("title",title);
        model.addAttribute("tag",tag);
        model.addAttribute("description",description);
        if(Strings.isEmpty(title)){
            model.addAttribute("error","title为空无法提交");
            return "/publish";
        }
        if (Strings.isEmpty(description)){
            model.addAttribute("error","description为空无法提交");
            return "/publish";
        }
        if (Strings.isEmpty(tag)){
            model.addAttribute("error","tag为空无法提交");
            return "/publish";
        }
        User user = (User) request.getSession().getAttribute("user");
        question.setCreator((user.getAccountId()));
        question.setViewCount(0);
        question.setCommentCount(0);
        question.setLikeCount(0);
        question.setGmtCreate(System.currentTimeMillis());
        question.setGmtModified(question.getGmtCreate());
        questionMapper.insert(question);
        model.addAttribute("title",null);
        model.addAttribute("tag",null);
        model.addAttribute("description",null);
        model.addAttribute("success","发布成功");
        return "/publish";
    }
    @GetMapping("/publish")
    public String toPublish(){
        return "publish";
    }
}
