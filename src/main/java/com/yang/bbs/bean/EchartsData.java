package com.yang.bbs.bean;

/**
 * @Description 该类是Echarts的数据类
 * @Author liuyangyang
 * @Date 2020/5/8 17:10
 */
public class EchartsData {
    /**
     *  图表显示想项
     */
    private String name;
    /**
     * 图表内容值
     */
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
