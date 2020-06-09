package com.yang.bbs.service;

import com.yang.bbs.bean.Collection;

import java.util.List;

/**
 * @Description 用户收藏帖子的业务处理层
 * @Author liuyangyang
 * @Date 2020/4/21 1:06
 */
public interface CollectionService {
    /**
     * 获取所有的帖子关注列表
     * @return
     */
    List<Collection> selectAll();

    /**
     * 动态获取关注帖子的列表
     * @param collection
     * @return
     */
    List<Collection> selectList(Collection collection,Integer page,Integer size);

    Boolean deleteUserById(Integer id);

    Boolean addCollection(Collection user);

    Boolean updateCollection(Collection user);
}
