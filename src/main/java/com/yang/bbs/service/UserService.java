package com.yang.bbs.service;

import com.yang.bbs.bean.EchartsData;
import com.yang.bbs.bean.User;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 21:23
 */
public interface UserService {
    /**
     * 查询用户列表
     * @return
     */
    List<User> selectAll();
    /**
     * 动态查询用户列表
     * @return
     */
    List<User> selectList(User user,Integer page,Integer size);

    /**
     * 通过用户名和密码验证登录
     * @param username
     * @param password
     * @return
     */
    User getUserByNameAndPass(String username,String password);

    Boolean deleteUserById(Integer uid);

    /**
     * 新增用户
     * @param user
     * @return
     */
    Boolean addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return
     */
    Boolean updateUser(User user);

    User getOneUser(Integer id);

    List<EchartsData> getUserCharts();
}
