package com.lxh.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author LXH
 * @date 2019/8/29 -7:29
 */
@Controller
@RequestMapping("/profile")
public class profileController {
    @GetMapping("/question")
    public String question(Model model) {
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
