package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.Invitation;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/25 15:23
 */
public class InvitationReq {
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
    private Invitation invitation;

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

    public Invitation getInvitation() {
        return invitation;
    }

    public void setInvitation(Invitation invitation) {
        this.invitation = invitation;
    }

}
