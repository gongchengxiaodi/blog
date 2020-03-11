package com.huihui.mapper;

import com.huihui.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/*
* 用户处理
* */
@Mapper
@Repository
public interface UserMapper {
    public User queryUserByName(String username);
}
