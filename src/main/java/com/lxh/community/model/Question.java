package com.lxh.community.model;

import lombok.Data;

/**
 * @author LXH
 * @date 2019/8/28 -15:36
 */
@Data
public class Question {
    private Integer id;
    private String title ;
    private String description ;
    private String tag ;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
}
