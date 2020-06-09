package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Collection;
import com.yang.bbs.mapper.CollectionMapper;
import com.yang.bbs.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/21 1:06
 */
@Service
public class CollectionServiceImpl implements CollectionService {

    @Autowired
    CollectionMapper collectionMapper;
    @Override
    public List<Collection> selectAll() {
        return collectionMapper.selectAll();
    }

    @Override
    public List<Collection> selectList(Collection collection,Integer page,Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Collection> collections = collectionMapper.selectList(collection);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(collections);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return collectionMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addCollection(Collection user) {
        return collectionMapper.insertSelective(user)>0;
    }

    @Override
    public Boolean updateCollection(Collection user) {
        return collectionMapper.updateByPrimaryKeySelective(user)>0;
    }
}
