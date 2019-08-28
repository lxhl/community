package com.lxh.community.dto;

/**
 * @author LXH
 * @date 2019/8/28 -10:47
 * 接受github返回的用户，并将自己有用的的用户信息保存起来，封装到用户对象
 */
public class GitHubUser {
    private String name ;
    private Long id;
    private String bio ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public GitHubUser() {
    }

    public GitHubUser(String name, Long id, String bio) {
        this.name = name;
        this.id = id;
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "GitHubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }
}
