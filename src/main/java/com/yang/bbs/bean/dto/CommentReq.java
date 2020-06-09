package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.Comment;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/24 16:32
 */
public class CommentReq {
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
    private Comment comment;

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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentReq{" +
                "page=" + page +
                ", size=" + size +
                ", comment=" + comment +
                '}';
    }
}
