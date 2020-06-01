package com.ch.wchya.study.sptboot.mapper;

import com.ch.wchya.study.sptboot.dao.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: spt-boot
 * @description:
 * @author: 王超
 * @create: 2020-06-01 22:52
 **/
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    void insert(User user);
}
