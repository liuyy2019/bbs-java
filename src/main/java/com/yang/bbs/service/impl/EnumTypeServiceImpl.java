package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.EnumType;
import com.yang.bbs.mapper.EnumTypeMapper;
import com.yang.bbs.service.EnumTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/22 16:08
 */
@Service
public class EnumTypeServiceImpl implements EnumTypeService {

    @Autowired
    private EnumTypeMapper enumTypeMapper;

    @Override
    public List<EnumType> selectAll() {
        return enumTypeMapper.selectAll();
    }

    @Override
    public List<EnumType> selectList(EnumType enumType, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<EnumType> enumTypes = enumTypeMapper.selectList(enumType);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(enumTypes);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteEnumTypeById(Integer id) {
        return enumTypeMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addEnumType(EnumType enumType) {
        enumType.setCreateTime(LocalDateTime.now());
        return enumTypeMapper.insertSelective(enumType)>0;
    }

    @Override
    public Boolean updateEnumType(EnumType enumType) {
        return enumTypeMapper.updateByPrimaryKeySelective(enumType)>0;
    }
}
