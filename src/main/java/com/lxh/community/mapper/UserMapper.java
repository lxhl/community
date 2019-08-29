package com.lxh.community.mapper;

import com.lxh.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author LXH
 * @date 2019/8/28 -13:35
 */
@Mapper
@Repository
public interface UserMapper {
    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified,avatar) values(#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified},#{avatar})")
     void insert(User user);
    User FindByToken(String token);
    @Select("select id from user where account_id=#{AccountId}")
    User FindByAccountId(Long AccountId);

    void updateToken(User user);
}
