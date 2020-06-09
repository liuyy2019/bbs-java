package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.Invitationtype;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 22:47
 */
public class InvitationTypeReq {
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
    private Invitationtype invitationtype;

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

    public Invitationtype getInvitationtype() {
        return invitationtype;
    }

    public void setInvitationtype(Invitationtype invitationtype) {
        this.invitationtype = invitationtype;
    }
}
