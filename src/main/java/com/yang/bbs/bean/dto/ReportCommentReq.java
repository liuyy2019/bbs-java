package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.ReportComment;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/19 17:33
 */
public class ReportCommentReq {
    /**
     *  分页显示的页数
     */
    private Integer page;
    /**
     * 每页显示的条数
     */
    private Integer size;
    /**
     * 请求的对象主体
     */
    private ReportComment reportComment;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public ReportComment getReportComment() {
        return reportComment;
    }

    public void setReportComment(ReportComment reportComment) {
        this.reportComment = reportComment;
    }
}
