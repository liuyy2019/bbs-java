package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.Announcement;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 14:37
 */
public class AnnouncementReq {
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
    private Announcement announcement;

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

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
    }

    @Override
    public String toString() {
        return "AnnouncementReq{" +
                "page=" + page +
                ", size=" + size +
                ", announcement=" + announcement +
                '}';
    }
}
