package com.yang.bbs.service;

import com.yang.bbs.bean.ReportComment;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/19 16:56
 */
public interface ReportCommentService {

    /**
     * 获取所有的评论举报信息
     * @return
     */
    List<ReportComment> selectAll();

    /**
     * 动态分页获取评论举报信息
     * @param reportComment
     * @param page
     * @param size
     * @return
     */
    List<ReportComment> selectList(ReportComment reportComment,Integer page,Integer size);

    /**
     * 根据id删除评论举报信息
     * @param id
     * @return
     */
    Boolean deleteReportCommentById(Integer id);

    /**
     * 插入评论举报信息
     * @param reportComment
     * @return
     */
    Boolean insertReportComment(ReportComment reportComment);

    /**
     * 更新评论举报信息
     * @param reportComment
     * @return
     */
    ReportComment updateReportComment(ReportComment reportComment);

    /**
     * 根据评论id，获取评论中的所有举报信息
     * @return
     */
    List<ReportComment> selectReportCommentById(Integer id);

    List<ReportComment> selectListById(ReportComment reportComment);
}
