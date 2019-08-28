package com.lxh.community;

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
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommunityApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionDTOMapper questionDTOMapper;
    @Test
    public void contextLoads() {
        List<QuestionDTO> list = questionDTOMapper.selectList();
        System.out.println(list);
    }
    @Test
    public void test(){
        User user = userMapper.FindByToken("3b26710f-3bd3-47b2-bc92-479f19667732");
        System.out.println(user);
    }
}
