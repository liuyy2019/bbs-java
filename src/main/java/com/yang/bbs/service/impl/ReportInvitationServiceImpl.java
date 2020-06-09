package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.ReportInvitation;
import com.yang.bbs.mapper.ReportInvitationMapper;
import com.yang.bbs.service.ReportInvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:43
 */
@Service
public class ReportInvitationServiceImpl implements ReportInvitationService {

    @Autowired
    private ReportInvitationMapper reportInvitationMapper;

    @Override
    public List<ReportInvitation> selectAll() {
        return reportInvitationMapper.selectAll();
    }

    @Override
    public List<ReportInvitation> selectList(ReportInvitation reportInvitation, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<ReportInvitation> reportInvitations = reportInvitationMapper.selectList(reportInvitation);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(reportInvitations);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteReportInvitationById(Integer id) {
        return reportInvitationMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean insertReportInvitation(ReportInvitation reportInvitation) {
        reportInvitation.setCreateTime(LocalDateTime.now());
        reportInvitation.setUpdateTime(LocalDateTime.now());
        return reportInvitationMapper.insertSelective(reportInvitation)>0;
    }

    @Override
    public ReportInvitation updateReportInvitation(ReportInvitation reportInvitation) {
        reportInvitation.setUpdateTime(LocalDateTime.now());
        reportInvitationMapper.updateByPrimaryKeySelective(reportInvitation);
        return reportInvitation;
    }

    @Override
    public List<ReportInvitation> selectListById(ReportInvitation reportInvitation) {
        return reportInvitationMapper.selectListById(reportInvitation);
    }
}
