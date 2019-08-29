package com.lxh.community.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxh.community.dto.QuestionDTO;
import com.lxh.community.mapper.QuestionDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author LXH
 * @date 2019/8/29 -9:41
 */
@Controller
public class PageController {
    @Autowired
    private QuestionDTOMapper questionDTOMapper;
    @GetMapping("/pageInfo")
    public String pageCount(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize,
                            Model model){
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<QuestionDTO> pageInfo=new PageInfo<>(questionDTOMapper.selectList(),5);
        model.addAttribute("pageInfo",pageInfo);
        return "test";
    }

    @ResponseBody
    @GetMapping("/pageInfoJSON")
    public PageInfo<QuestionDTO> pageInfoJSON(@RequestParam(value = "pageNumber",defaultValue = "1") Integer pageNumber,
                            @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize
                            ){
        PageHelper.startPage(pageNumber,pageSize);
        PageInfo<QuestionDTO> pageInfo=new PageInfo<>(questionDTOMapper.selectList(),5);
        return pageInfo;
    }

}
