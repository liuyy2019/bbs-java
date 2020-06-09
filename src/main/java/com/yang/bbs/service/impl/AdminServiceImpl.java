package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Admin;
import com.yang.bbs.bean.Announcement;
import com.yang.bbs.mapper.AdminMapper;
import com.yang.bbs.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 21:08
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    @Override
    public List<Admin> selectList(Admin admin, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Admin> admins = adminMapper.selectList(admin);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(admins);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return adminMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addAdmin(Admin admin) {
        return adminMapper.insertSelective(admin)>0;
    }

    @Override
    public Boolean updateAdmin(Admin admin) {
        return adminMapper.updateByPrimaryKeySelective(admin)>0;
    }

    @Override
    public Admin getAdminByNameAndPass(String username, String password) {
        return adminMapper.getAdminByNameAndPass(username,password);
    }
}
