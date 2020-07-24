package com.ssm.dao;

import com.ssm.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jfy on 2020/7/13 0013.
 * 用户的持久层接口
 */
public interface IUserDao {
    /**
     查询所有操作
     */
    @Select("select * from userinfo")
    List<User> findAll();
}
