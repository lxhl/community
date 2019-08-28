package com.lxh.community.model;

import lombok.Data;

/**
 * @author LXH
 * @date 2019/8/28 -13:36
 */
@Data
public class User {
    private Integer id;
    private String name ;
    private Long accountId ;
    private String token ;
    private Long gmtCreate;
    private Long gmtModified;
    private String avatar;

}
