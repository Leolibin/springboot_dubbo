package com.sugon.springboot_dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sugon.springboot_dubbo.mapper.UserMapper;
import com.sugon.springboot_dubbo.model.User;
import com.sugon.springboot_dubbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leoli
 * Date: 2019-08-05
 */
@Component   //将该类变为spring的一个bean
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {
        return userMapper.selectUserByPage(paramMap);
    }

    @Override
    public int getUserByTotal() {
        return userMapper.selectUserByTotal();
    }
}
