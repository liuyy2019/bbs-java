package com.yang.bbs.service;

import com.yang.bbs.bean.Attention;


import java.util.List;

/**
 * @Description 用户关注对象的业务处层
 * @Author liuyangyang
 * @Date 2020/4/21 0:50
 */
public interface AttentionService {
    /**
     * 获取关注列表
     * @return
     */
    List<Attention> getAllAttention();

    /**
     * 根据对象的属性动态获取关注列表
     * @param attention
     * @return
     */
    List<Attention> getAttentions(Attention attention);

    /**
     * 动态的获取关注列表，支持分页
     * @param attention
     * @param page
     * @param size
     * @return
     */
    List<Attention> selectList(Attention attention, Integer page, Integer size);

    Boolean deleteUserById(Integer id);

    Boolean addAttention(Attention attention);

    Boolean updateAttention(Attention attention);

    List<Attention> selectListByName(Attention attention);
}
