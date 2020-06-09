package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.EchartsData;
import com.yang.bbs.bean.User;
import com.yang.bbs.mapper.UserMapper;
import com.yang.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 21:23
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public List<User> selectList(User user,Integer page,Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        String name = user.getName()==null?null:"%"+user.getName()+"%";
        user.setName(name);
        List<User> users = userMapper.selectList(user);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(users);
        return pageInfo.getList();
    }

    @Override
    public User getUserByNameAndPass(String username, String password) {
        return userMapper.getUserByNameAndPass(username,password);
    }

    @Override
    public Boolean deleteUserById(Integer userId) {
        return userMapper.deleteByPrimaryKey(userId)>0;
    }

    @Override
    public Boolean addUser(User user) {
        user.setCreatetime(LocalDate.now());
        user.setUpdatetime(LocalDate.now());
        user.setInvitationNumber(0);
        user.setReportNumber(0);
        return userMapper.insert(user)>0;
    }

    @Override
    public Boolean updateUser(User user) {
        user.setUpdatetime(LocalDate.now());
        return userMapper.updateByPrimaryKeySelective(user)>0 ;
    }

    @Override
    public User getOneUser(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<EchartsData> getUserCharts() {
        return userMapper.getUserCharts();
    }
}
