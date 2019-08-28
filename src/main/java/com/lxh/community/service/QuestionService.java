package com.lxh.community.service;

import com.lxh.community.dto.QuestionDTO;
import com.lxh.community.mapper.QuestionDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LXH
 * @date 2019/8/28 -20:36
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionDTOMapper questionDTOMapper;
    public List<QuestionDTO> list() {
        return questionDTOMapper.selectList();
    }
}
