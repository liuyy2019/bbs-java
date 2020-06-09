package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.Invitation;
import com.yang.bbs.mapper.InvitationMapper;
import com.yang.bbs.service.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/6 22:10
 */
@Service
public class InvitationServiceImpl implements InvitationService {

    @Autowired
    public InvitationMapper invitationMapper;

    @Override
    public List<Invitation> selectAll() {
        return invitationMapper.selectAll();
    }

    @Override
    public Invitation selectById(Integer id) {
        return invitationMapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean addInvitation(Invitation invitation) {
        invitation.setDate(LocalDateTime.now());
        int addRow = invitationMapper.insert(invitation);
        return addRow > 0;
    }

    @Override
    public List<Invitation> selectList(Invitation invitation, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        String title = invitation.getTitle()==null?null:"%"+invitation.getTitle()+"%";
        invitation.setTitle(title);
        List<Invitation> invitations = invitationMapper.selectList(invitation);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(invitations);
        return pageInfo.getList();
    }

    @Override
    public Boolean updateInvitation(Invitation invitation) {
        return invitationMapper.updateByPrimaryKeySelective(invitation)>0;
    }

    @Override
    public List<Invitation> getInvitationsByVisitors() {
        return invitationMapper.getInvitationsByVisitors();
    }

    @Override
    public Boolean deleteInvitation(Integer id) {
        return invitationMapper.deleteByPrimaryKey(id)>0;
    }
}
