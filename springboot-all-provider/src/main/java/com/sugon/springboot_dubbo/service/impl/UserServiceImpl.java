package com.sugon.springboot_dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.sugon.springboot_dubbo.model.User;
import com.sugon.springboot_dubbo.service.UserService;
import org.springframework.stereotype.Component;

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
    @Override
    public List<User> getUserByPage(Map<String, Object> paramMap) {
        return null;
    }

    @Override
    public int getUserByTotal() {
        return 0;
    }
}
