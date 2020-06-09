package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Attention;
import com.yang.bbs.mapper.AttentionMapper;
import com.yang.bbs.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/21 0:49
 */
@Service
public class AttentionServiceImpl implements AttentionService {

    @Autowired
    AttentionMapper attentionMapper;

    @Override
    public List<Attention> getAllAttention() {
        return attentionMapper.selectAll();
    }

    @Override
    public List<Attention> getAttentions(Attention attention) {
        return attentionMapper.selectList(attention);
    }

    @Override
    public List<Attention> selectList(Attention attention, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Attention> attentions = attentionMapper.selectList(attention);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(attentions);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return attentionMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addAttention(Attention attention) {
        attention.setCreatetime(LocalDateTime.now());
        return attentionMapper.insertSelective(attention)>0;
    }

    @Override
    public Boolean updateAttention(Attention attention) {
        return attentionMapper.updateByPrimaryKeySelective(attention)>0;
    }

    @Override
    public List<Attention> selectListByName(Attention attention) {
        List<Attention> attentionList = attentionMapper.selectListByName(attention);
        return attentionList;
    }
}
