package com.sugon.springboot_dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sugon.springboot_dubbo.model.User;
import com.sugon.springboot_dubbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: leoli
 * Date: 2019-08-05
 */
@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/index")
    public String index(Model model,
                        @RequestParam(value = "currentPage", required = false) Integer currentPage) {

        //定义每页的大小
        int pageSize = 5;

        if (null == currentPage || currentPage < 1) {
            currentPage = 1;
        }
        //查询总数
        int totalRaws = userService.getUserByTotal();
        //计算分页
        int totalPages = totalRaws / pageSize;
        //有可能会有余数
        int left = totalRaws % pageSize;
        if (left > 0) {
            totalPages += 1;
        }

        if (currentPage > totalPages){
            currentPage = totalPages;
        }

        //计算查询的开始行
        int startRow = (currentPage - 1) * pageSize;
        Map<String, Object> paramMap = new ConcurrentHashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", pageSize);
        List<User> userList = userService.getUserByPage(paramMap);

        //跳到模板页面
        model.addAttribute("userList", userList);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        return "index";
    }


    /**
     * 去添加用户
     * @return
     */
    @RequestMapping("/user/toAddUser")
    public String toAddUser(){
        return "addUser";
    }
}
