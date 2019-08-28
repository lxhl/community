package com.lxh.community.mapper;

import com.lxh.community.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LXH
 * @date 2019/8/28 -15:33
 */
@Mapper
@Repository
public interface QuestionMapper {
    void insert(Question question);
    @Select("select * from question")
    List<Question> list();
}
