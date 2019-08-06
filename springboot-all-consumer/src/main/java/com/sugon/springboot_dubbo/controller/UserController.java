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


    /**
     * 添加用户||修改用户
     * @param user
     * @return
     */
    @RequestMapping("/user/addUser")
    public String addUser(User user){

        Integer id = user.getId();
        if(null == id){
            //添加用户
            userService.addUser(user);
        }else {
            //修改用户
            userService.updateUser(user);
        }
        return "redirect:/index";
    }

    /**
     * 查询需要修改的对象
     * @param id
     * @return
     */
    @RequestMapping("/user/toUpdate")
    public String updateUser(Model model,
                             @RequestParam("id") Integer id){
        User user = userService.getUserById(id);
        model.addAttribute("user",user);
        return "addUser";
    }

    /**
     * 删除对象
     * @param id
     * @return
     */
    @RequestMapping("/user/deleteUser")
    public String deleteUser(Integer id){
        //删除用户
        userService.deleteUser(id);
        return "redirect:/index";
    }
}
