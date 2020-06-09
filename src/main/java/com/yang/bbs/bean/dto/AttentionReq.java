package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.Attention;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/25 15:23
 */
public class AttentionReq {

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
    private Attention attention;

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

    public Attention getAttention() {
        return attention;
    }

    public void setAttention(Attention attention) {
        this.attention = attention;
    }
}
