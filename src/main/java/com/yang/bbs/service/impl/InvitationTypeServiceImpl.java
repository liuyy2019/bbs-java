package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Invitationtype;
import com.yang.bbs.mapper.InvitationtypeMapper;
import com.yang.bbs.service.InvitationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/28 22:54
 */
@Service
public class InvitationTypeServiceImpl implements InvitationTypeService {
    @Autowired
    private InvitationtypeMapper invitationtypeMapper;
    @Override
    public List<Invitationtype> selectAll() {
        return invitationtypeMapper.selectAll();
    }

    @Override
    public List<Invitationtype> selectList(Invitationtype invitationtype, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<Invitationtype> admins = invitationtypeMapper.selectList(invitationtype);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(admins);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return invitationtypeMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean updateType(Invitationtype invitationtype) {
        invitationtype.setUpdateTime(LocalDateTime.now());
        return invitationtypeMapper.updateByPrimaryKeySelective(invitationtype)>0;
    }

    @Override
    public Boolean addType(Invitationtype invitationtype) {
        invitationtype.setCreateTime(LocalDateTime.now());
        invitationtype.setUpdateTime(LocalDateTime.now());
        return invitationtypeMapper.insertSelective(invitationtype)>0;
    }
}
