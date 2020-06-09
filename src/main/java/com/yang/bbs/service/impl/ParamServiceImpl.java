package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Param;
import com.yang.bbs.mapper.ParamMapper;
import com.yang.bbs.service.ParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/21 16:42
 */
@Service
public class ParamServiceImpl implements ParamService {

    @Autowired
    private ParamMapper paramMapper;

    @Override
    public List<Param> selectAll() {
        return paramMapper.selectAll();
    }

    @Override
    public List<Param> selectList(Param param, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Param> paramList = paramMapper.selectList(param);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(paramList);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteParamById(Integer id) {
        return paramMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addParam(Param param) {
        param.setCreateTime(LocalDate.now());
        param.setUpdateTime(LocalDate.now());
        return paramMapper.insertSelective(param)>0;
    }

    @Override
    public Boolean updateParam(Param param) {
        param.setUpdateTime(LocalDate.now());
        return paramMapper.updateByPrimaryKeySelective(param)>0;
    }

    @Override
    public Param selectByCodeId(String codeId) {
        return paramMapper.selectByCodeId(codeId);
    }
}
