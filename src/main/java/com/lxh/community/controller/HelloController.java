package com.lxh.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author LXH
 * @date 2019/8/27 -22:16
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
