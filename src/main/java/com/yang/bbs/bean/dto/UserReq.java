package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.User;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/24 16:32
 */
public class UserReq {
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
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserReq{" +
                "page=" + page +
                ", size=" + size +
                ", user=" + user +
                '}';
    }
}
