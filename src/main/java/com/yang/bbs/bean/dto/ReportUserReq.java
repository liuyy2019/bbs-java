package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.ReportUser;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:18
 */
public class ReportUserReq {
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
    private ReportUser reportUser;

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

    public ReportUser getReportUser() {
        return reportUser;
    }

    public void setReportUser(ReportUser reportUser) {
        this.reportUser = reportUser;
    }
}
