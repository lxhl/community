package com.lxh.community.dto;

import com.lxh.community.model.User;
import lombok.Data;

/**
 * @author LXH
 * @date 2019/8/28 -20:24
 */
@Data
public class QuestionDTO {
    private Integer id;
    private String title ;
    private String description ;
    private String tag ;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
