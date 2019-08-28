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
    @Insert("insert into user(account_id,name,token,gmt_create,gmt_modified) values(#{accountId},#{name},#{token},#{gmtCreate},#{gmtModified})")
     void insert(User user);
    @Select("select * from user where token=#{token}")
    User FindByToken(String token);
}
