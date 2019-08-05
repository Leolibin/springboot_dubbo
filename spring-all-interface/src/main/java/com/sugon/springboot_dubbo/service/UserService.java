package com.sugon.springboot_dubbo.service;

import com.sugon.springboot_dubbo.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leoli
 * Date: 2019-08-05
 */
public interface UserService {

    /**
     * 列表分页查询接口
     * @param paramMap
     * @return
     */
    List<User> getUserByPage(Map<String,Object> paramMap);

    /**
     * 分页查询该表中的数据总数
     * @return
     */
    int getUserByTotal();

}
