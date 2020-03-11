package com.huihui.service;

import com.huihui.domain.User;
import com.huihui.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
