package com.lxh.community.controller;

import com.lxh.community.mapper.QuestionMapper;
import com.lxh.community.model.Question;
import com.lxh.community.model.User;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        model.addAttribute("question",question);
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
        if (question.getId()==null){
            questionMapper.insert(question);
            model.addAttribute("success","发布成功");
        }else {
            questionMapper.update(question);
            model.addAttribute("success","更新成功");
        }
        model.addAttribute("question",null);
        return "/publish";
    }
    @GetMapping("/publish")
    public String toPublish(){
        return "publish";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(value = "id") String id,
                       Model model){
        Question question = questionMapper.selectById(Integer.parseInt(id));
        model.addAttribute("question",question);
        return "publish";
    }
}
