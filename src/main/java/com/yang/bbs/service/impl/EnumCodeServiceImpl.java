package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.EnumCode;
import com.yang.bbs.mapper.EnumCodeMapper;
import com.yang.bbs.service.EnumCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/22 16:09
 */
@Service
public class EnumCodeServiceImpl implements EnumCodeService {

    @Autowired
    private EnumCodeMapper enumCodeMapper;

    @Override
    public List<EnumCode> selectAll() {
        return enumCodeMapper.selectAll();
    }

    @Override
    public List<EnumCode> codeListByType(EnumCode enumCode) {
        List<EnumCode> enumCodes = enumCodeMapper.selectList(enumCode);
        return enumCodes;
    }

    @Override
    public List<EnumCode> selectList(EnumCode enumCode, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<EnumCode> enumCodes = enumCodeMapper.selectList(enumCode);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(enumCodes);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteEnumCodeById(Integer id) {
        return enumCodeMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean addEnumCode(EnumCode enumCode) {
        enumCode.setCreateTime(LocalDateTime.now());
        return enumCodeMapper.insertSelective(enumCode)>0;
    }

    @Override
    public Boolean updateEnumCode(EnumCode enumCode) {
        return enumCodeMapper.updateByPrimaryKeySelective(enumCode)>0;
    }
}
