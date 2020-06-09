package com.yang.bbs.service;

import com.yang.bbs.bean.Admin;
import com.yang.bbs.bean.EnumCode;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/22 16:09
 */
public interface EnumCodeService {
    /**
     * 获取所有枚举码
     * @return
     */
    List<EnumCode> selectAll();

    /**
     * 通过枚举码动态获取对应的信息
     * @param enumCode
     * @return
     */
    List<EnumCode> codeListByType(EnumCode enumCode);

    /**
     * 分页查询，动态获取枚举码信息
     * @param enumCode
     * @param page
     * @param size
     * @return
     */
    List<EnumCode> selectList(EnumCode enumCode,Integer page,Integer size);

    /**
     * 通过id枚举码信息
     * @param id
     * @return
     */
    Boolean deleteEnumCodeById(Integer id);

    /**
     * 新增枚举吗信息
     * @param enumCode
     * @return
     */
    Boolean addEnumCode(EnumCode enumCode);

    /**
     * 修改枚举码信息
     * @param enumCode
     * @return
     */
    Boolean updateEnumCode(EnumCode enumCode);
}
