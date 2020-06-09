package com.yang.bbs.controller;

import com.yang.bbs.bean.EchartsData;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.UserReq;
import com.yang.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 21:29
 */
@RestController
@RequestMapping("/v1")
public class UserController {

    @Autowired
    public UserService userService;

    /**
     * 查询用户列表
     * @return
     */
    @GetMapping("/user/userList")
    public List<User> userAll(){
        return userService.selectAll();
    }

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    @GetMapping("/user/one/{id}")
    public User getOneUser(@PathVariable("id") Integer id){
        return userService.getOneUser(id);
    }

    /**
     * 动态的获取用户列表
     * @return
     */
    @PostMapping("/user/user/test")
    public List<User> userList(@RequestBody UserReq userReq){
        List<User> userList = userService.selectList(userReq.getUser(),userReq.getPage(),userReq.getSize());
        return userList;
    }

    /**
     * 根据用户名和密码进行登录验证
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/user/user")
    public User getUser(@RequestParam("username") String username,@RequestParam("password") String password){
        return userService.getUserByNameAndPass(username,password);
    }

    /**
     * 根据id删除用户
     * @param uid
     * @return
     */
    @DeleteMapping("/user/user/{uid}")
    public Boolean deleteUser(@PathVariable("uid") Integer uid){
        return userService.deleteUserById(uid);
    }

    /**
     *  添加用户
     * @param user
     * @return
     */
    @PostMapping("/user/add")
    public Boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     *  更新用户
     * @param user
     * @return
     */
    @PutMapping("/user/update")
    public Boolean updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 获取用户相关的图表数据
     * @return
     */
    @GetMapping("/user/echarts/user")
    public List<EchartsData> getUserCharts(){
        List<EchartsData> lists = userService.getUserCharts();
        return lists;
    }
}
