package com.yang.bbs.controller;

import com.yang.bbs.bean.Admin;
import com.yang.bbs.bean.Announcement;
import com.yang.bbs.bean.User;
import com.yang.bbs.bean.dto.AdminReq;
import com.yang.bbs.bean.dto.AnnouncementReq;
import com.yang.bbs.service.AdminService;
import com.yang.bbs.service.AnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 21:13
 */
@RestController
@RequestMapping("/v1")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 根据用户名和密码进行登录验证
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/admin/login")
    public Admin adminLogin(@RequestParam("username") String username,@RequestParam("password") String password){
        return adminService.getAdminByNameAndPass(username,password);
    }

    /**
     * 获取所有的管理员信息
     * @return
     */
    @ApiOperation(value = "获取所有的管理员信息")
    @GetMapping("/admin/adminList")
    public List<Admin> getAllAnswer(){
        return adminService.selectAll();
    }

    /**
     * 分页动态的获取管理员信息
     * @return
     */
    @ApiOperation(value = "分页动态的获取管理员信息")
    @PostMapping("/admin/admin/page")
    public List<Admin> adminList(
            @ApiParam("请求对象实体")
            @RequestBody AdminReq adminReq){
        List<Admin> adminList = adminService.selectList(adminReq.getAdmin(),adminReq.getPage(),adminReq.getSize());
        return adminList;
    }

    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id删除管理员")
    @DeleteMapping("/admin/admin/{id}")
    public Boolean deleteAdmin(@PathVariable("id") Integer id){
        return adminService.deleteUserById(id);
    }

    /**
     *  添加管理员
     * @param admin
     * @return
     */
    @ApiOperation(value = "添加管理员")
    @PostMapping("/admin/add")
    public Boolean addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    /**
     *  更新管理员信息
     * @param admin
     * @return
     */
    @ApiOperation(value = "更新管理员信息")
    @PutMapping("/admin/update")
    public Boolean updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

}
