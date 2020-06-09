package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.ReportUser;
import com.yang.bbs.mapper.ReportUserMapper;
import com.yang.bbs.service.ReportUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:31
 */
@Service
public class ReportUserServiceImpl implements ReportUserService {

    @Autowired
    private ReportUserMapper reportUserMapper;

    @Override
    public List<ReportUser> selectAll() {
        return reportUserMapper.selectAll();
    }

    @Override
    public List<ReportUser> selectList(ReportUser reportUser, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<ReportUser> reportUsers = reportUserMapper.selectList(reportUser);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(reportUsers);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteReportUserById(Integer id) {
        return reportUserMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean insertReportUser(ReportUser reportUser) {
        reportUser.setCreateTime(LocalDateTime.now());
        reportUser.setUpdateTime(LocalDateTime.now());
        return reportUserMapper.insertSelective(reportUser)>0;
    }

    @Override
    public ReportUser updateReportUser(ReportUser reportUser) {
        reportUser.setUpdateTime(LocalDateTime.now());
        reportUserMapper.updateByPrimaryKeySelective(reportUser);
        return reportUser;
    }

    @Override
    public List<ReportUser> selectListById(ReportUser reportUser) {
        return reportUserMapper.selectListById(reportUser);
    }
}
