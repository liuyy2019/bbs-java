package com.yang.bbs.bean.dto;

import com.yang.bbs.bean.EnumCode;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/22 15:58
 */
public class EnumCodeReq {
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
    private EnumCode enumCode;

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

    public EnumCode getEnumCode() {
        return enumCode;
    }

    public void setEnumCode(EnumCode enumCode) {
        this.enumCode = enumCode;
    }
}
