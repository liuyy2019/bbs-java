package com.yang.bbs.controller;


import com.yang.bbs.bean.ReportUser;
import com.yang.bbs.bean.dto.ReportUserReq;
import com.yang.bbs.service.ReportUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:52
 */
@RestController
@RequestMapping("/v1")
public class ReportUserController {

    @Autowired
    private ReportUserService reportUserService;

    /**
     * 获取所有的管理员信息
     * @return
     */
    @GetMapping("/reportUser/reportUserList")
    public List<ReportUser> getAllReportUser(){
        return reportUserService.selectAll();
    }

    /**
     * 动态的获取管理员信息分页
     * @return
     */
    @PostMapping("/reportUser/reportUser/page")
    public List<ReportUser> reportUserList(@RequestBody ReportUserReq reportUserReq){
        List<ReportUser> reportUserList = reportUserService.selectList(reportUserReq.getReportUser(),reportUserReq.getPage(),reportUserReq.getSize());
        return reportUserList;
    }

    /**
     * 获取管理员信息列表通过id
     * @return
     */
    @PostMapping("/reportUser/sort")
    public List<ReportUser> reportUserListById(@RequestBody ReportUser reportUser){
        List<ReportUser> reportUserList = reportUserService.selectListById(reportUser);
        return reportUserList;
    }

    /**
     * 根据id删除举报信息
     * @param id
     * @return
     */
    @DeleteMapping("/reportUser/reportUser/{id}")
    public Boolean deleteReportUserById(@PathVariable("id") Integer id){
        return reportUserService.deleteReportUserById(id);
    }

    /**
     *  添加举报信息
     * @param reportUser
     * @return
     */
    @PostMapping("/reportUser/add")
    public Boolean insertReportUser(@RequestBody ReportUser reportUser) {
        return reportUserService.insertReportUser(reportUser);
    }

    /**
     *  更新举报信息
     * @param reportUser
     * @return
     */
    @PutMapping("/reportUser/update")
    public ReportUser updateReportUser(@RequestBody ReportUser reportUser) {
        return reportUserService.updateReportUser(reportUser);
    }


}
