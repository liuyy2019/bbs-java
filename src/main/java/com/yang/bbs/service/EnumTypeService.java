package com.yang.bbs.service;

import com.yang.bbs.bean.Admin;
import com.yang.bbs.bean.EnumType;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/22 16:09
 */
public interface EnumTypeService {
    /**
     * 获取所有的参数枚举类型
     * @return
     */
    List<EnumType> selectAll();

    /**
     * 分页查询，动态的获取相应的枚举类型
     * @param enumType
     * @param page
     * @param size
     * @return
     */
    List<EnumType> selectList(EnumType enumType,Integer page,Integer size);

    /**
     * 通过id删除枚举类型
     * @param id
     * @return
     */
    Boolean deleteEnumTypeById(Integer id);

    /**
     * 新增枚举类型
     * @param enumType
     * @return
     */
    Boolean addEnumType(EnumType enumType);

    /**
     * 更新枚举类型
     * @param enumType
     * @return
     */
    Boolean updateEnumType(EnumType enumType);
}
