package com.yang.bbs.service;

import com.yang.bbs.bean.Admin;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 21:09
 */
public interface AdminService {
    List<Admin> selectAll();
    List<Admin> selectList(Admin admin,Integer page,Integer size);

    Boolean deleteUserById(Integer id);

    Boolean addAdmin(Admin admin);

    Boolean updateAdmin(Admin admin);

    Admin getAdminByNameAndPass(String username, String password);
}
