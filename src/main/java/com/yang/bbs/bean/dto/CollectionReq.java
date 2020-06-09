package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.Collection;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/25 15:23
 */
public class CollectionReq {

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
    private Collection collection;

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

    public Collection getCollection() {
        return collection;
    }

    public void setCollection(Collection collection) {
        this.collection = collection;
    }
}
