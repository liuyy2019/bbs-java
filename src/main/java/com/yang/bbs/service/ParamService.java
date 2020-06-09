package com.yang.bbs.service;

import com.yang.bbs.bean.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/21 16:42
 */
public interface ParamService {
    /**
     * 获取所有的参数列表
     * @return
     */
    List<Param> selectAll();

    /**
     * 动态、分页获取符合的参数列表
     * @param param
     * @param page
     * @param size
     * @return
     */
    List<Param> selectList(Param param,Integer page,Integer size);

    /**
     * 通过id删除参数信息
     * @param id
     * @return
     */
    Boolean deleteParamById(Integer id);

    /**
     * 添加参数信息
     * @param param
     * @return
     */
    Boolean addParam(Param param);

    /**
     * 更新参数信息
     * @param param
     * @return
     */
    Boolean updateParam(Param param);

    /**
     * 获取参数码信息
     * @param codeId
     * @return
     */
    Param selectByCodeId(String codeId);
}
