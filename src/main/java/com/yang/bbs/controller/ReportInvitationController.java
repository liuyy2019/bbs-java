package com.yang.bbs.controller;

import com.yang.bbs.bean.ReportInvitation;
import com.yang.bbs.bean.dto.ReportInvitationReq;
import com.yang.bbs.service.ReportInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:57
 */
@RestController
@RequestMapping("/v1")
public class ReportInvitationController {

    @Autowired
    private ReportInvitationService reportInvitationService;

    /**
     * 获取所有的帖子举报信息
     * @return
     */
    @GetMapping("/reportInvitation/reportInvitationList")
    public List<ReportInvitation> getAllReportInvitation(){
        return reportInvitationService.selectAll();
    }

    /**
     * 获取管理员信息列表通过id
     * @return
     */
    @PostMapping("/reportInvitation/sort")
    public List<ReportInvitation> reportUserListById(@RequestBody ReportInvitation reportInvitation){
        List<ReportInvitation> reportUserList = reportInvitationService.selectListById(reportInvitation);
        return reportUserList;
    }

    /**
     * 动态的获取帖子举报信息分页
     * @return
     */
    @PostMapping("/reportInvitation/reportInvitation/page")
    public List<ReportInvitation> reportUserList(@RequestBody ReportInvitationReq reportInvitationReq){
        List<ReportInvitation> reportInvitationList = reportInvitationService.selectList(reportInvitationReq.getReportInvitation(),reportInvitationReq.getPage(),reportInvitationReq.getSize());
        return reportInvitationList;
    }

    /**
     * 根据id查出帖子举报信息
     * @param id
     * @return
     */
    @DeleteMapping("/reportInvitation/reportInvitation/{id}")
    public Boolean deleteReportInvitationById(@PathVariable("id") Integer id){
        return reportInvitationService.deleteReportInvitationById(id);
    }

    /**
     *  添加帖子举报信息
     * @param reportInvitation
     * @return
     */
    @PostMapping("/reportInvitation/add")
    public Boolean insertReportUser(@RequestBody ReportInvitation reportInvitation) {
        return reportInvitationService.insertReportInvitation(reportInvitation);
    }

    /**
     *  更新帖子举报信息
     * @param reportInvitation
     * @return
     */
    @PutMapping("/reportInvitation/update")
    public ReportInvitation updateReportUser(@RequestBody ReportInvitation reportInvitation) {
        return reportInvitationService.updateReportInvitation(reportInvitation);
    }

}
