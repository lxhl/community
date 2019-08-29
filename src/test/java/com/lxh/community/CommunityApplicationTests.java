package com.lxh.community;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lxh.community.dto.QuestionDTO;
import com.lxh.community.mapper.QuestionDTOMapper;
import com.lxh.community.mapper.QuestionMapper;
import com.lxh.community.mapper.UserMapper;
import com.lxh.community.model.Question;
import com.lxh.community.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class CommunityApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private QuestionDTOMapper questionDTOMapper;
    @Test
    public void contextLoads() {
        List<QuestionDTO> list = questionDTOMapper.selectList();
        System.out.println(list);
    }

    @Test
    public void test(){
        PageHelper.startPage(1,3);
        PageInfo<Question> pageInfo=new PageInfo<>(questionMapper.list());
        List<Question> list = pageInfo.getList();
        for (Question question : list) {
            System.out.println(question.toString());
        }

    }
}
