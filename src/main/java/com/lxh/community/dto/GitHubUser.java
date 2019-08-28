package com.lxh.community.dto;

import lombok.Data;

/**
 * @author LXH
 * @date 2019/8/28 -10:47
 * 接受github返回的用户，并将自己有用的的用户信息保存起来，封装到用户对象
 */
@Data
public class GitHubUser {
    private String name ;
    private Long id;
    private String bio ;
    private String avatar_url;
}
