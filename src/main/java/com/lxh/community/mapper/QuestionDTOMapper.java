package com.lxh.community.mapper;

import com.lxh.community.dto.QuestionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author LXH
 * @date 2019/8/28 -20:41
 */
@Mapper
@Repository
public interface QuestionDTOMapper {
    List<QuestionDTO> selectList();
    List<QuestionDTO> selectListByAccountId(Long accountId);
    QuestionDTO selectByQuestionId(Integer id);
}
