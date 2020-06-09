package com.yang.bbs.controller;

import com.yang.bbs.bean.ReportComment;
import com.yang.bbs.bean.ReportInvitation;
import com.yang.bbs.bean.ReportUser;
import com.yang.bbs.bean.dto.ReportCommentReq;
import com.yang.bbs.bean.dto.ReportUserReq;
import com.yang.bbs.service.ReportCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/19 16:55
 */
@RestController
@RequestMapping("/v1")
public class ReportCommentController {

    @Autowired
    private ReportCommentService reportCommentService;

    /**
     * 获取所有的管理员信息
     * @return
     */
    @GetMapping("/reportComment/reportCommentList")
    public List<ReportComment> getAllReportComment(){
        return reportCommentService.selectAll();
    }

    /**
     * 获取管理员信息列表通过id
     * @return
     */
    @PostMapping("/reportComment/sort")
    public List<ReportComment> reportUserListById(@RequestBody ReportComment reportComment){
        List<ReportComment> reportUserList = reportCommentService.selectListById(reportComment);
        return reportUserList;
    }

    /**
     * 根据评论id，获取评论中的所有举报信息
     * @return
     */
    @GetMapping("/reportCommentList/byId/{id}")
    public List<ReportComment> getReportCommentById(@PathVariable("id") Integer id){
        List<ReportComment> reportCommentList = reportCommentService.selectReportCommentById(id);
        return reportCommentList;
    }

    /**
     * 动态的获取公告分页
     * @return
     */
    @PostMapping("/reportComment/reportComment/page")
    public List<ReportComment> reportUserList(@RequestBody ReportCommentReq reportCommentReq){
        List<ReportComment> reportUserList = reportCommentService.selectList(reportCommentReq.getReportComment(),reportCommentReq.getPage(),reportCommentReq.getSize());
        return reportUserList;
    }

    /**
     * 根据id删除评论举报信息
     * @param id
     * @return
     */
    @DeleteMapping("/reportComment/reportComment/{id}")
    public Boolean deleteReportUserById(@PathVariable("id") Integer id){
        return reportCommentService.deleteReportCommentById(id);
    }

    /**
     *  添加评论举报信息
     * @param reportComment
     * @return
     */
    @PostMapping("/reportComment/add")
    public Boolean insertReportUser(@RequestBody ReportComment reportComment) {
        return reportCommentService.insertReportComment(reportComment);
    }

    /**
     *  更新评论举报信息
     * @param reportComment
     * @return
     */
    @PutMapping("/reportComment/update")
    public ReportComment updateReportUser(@RequestBody ReportComment reportComment) {
        return reportCommentService.updateReportComment(reportComment);
    }

}
