package com.lxh.community.dto;

import lombok.Data;

/**
 * @author LXH
 * @date 2019/8/28 -10:19
 * 如果要访问的api的参数超过两个，就要将参数封装成一个对象
 */
@Data
public class AccessTokenDTO {
    private String client_id ;
    private String client_secret ;
    private String code;
    private String redirect_uri ;
    private String state ;
}
