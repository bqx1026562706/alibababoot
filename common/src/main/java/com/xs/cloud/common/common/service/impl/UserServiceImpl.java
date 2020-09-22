package com.xs.cloud.common.common.service.impl;

import com.xs.cloud.common.common.mapper.UserMapper;
import com.xs.cloud.common.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<Map> testCity() {
        List<Map> maps =    userMapper.testCity();

        return maps;
    }




}
