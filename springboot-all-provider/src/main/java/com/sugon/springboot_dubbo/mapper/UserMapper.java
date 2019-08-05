package com.sugon.springboot_dubbo.mapper;

import com.sugon.springboot_dubbo.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectUserByTotal();

    List<User> selectUserByPage(Map<String, Object> paramMap);
}