package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.ReportInvitation;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:19
 */
public class ReportInvitationReq {
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
    private ReportInvitation reportInvitation;

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

    public ReportInvitation getReportInvitation() {
        return reportInvitation;
    }

    public void setReportInvitation(ReportInvitation reportInvitation) {
        this.reportInvitation = reportInvitation;
    }
}
