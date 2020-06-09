package com.yang.bbs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.bbs.bean.ReportComment;
import com.yang.bbs.bean.ReportUser;
import com.yang.bbs.mapper.ReportCommentMapper;
import com.yang.bbs.service.ReportCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/5/19 16:55
 */
@Service
public class ReportCommentServiceImpl implements ReportCommentService {

    @Autowired
    private ReportCommentMapper reportCommentMapper;

    @Override
    public List<ReportComment> selectAll() {
        return reportCommentMapper.selectAll();
//        return reportCommentMapper.selectList(reportComment);
    }

    @Override
    public List<ReportComment> selectList(ReportComment reportComment, Integer page, Integer size) {
        //设置分页的格式
        PageHelper.startPage(page,size);
        List<ReportComment> reportUsers = reportCommentMapper.selectList(reportComment);
        //对查询的所有结果进行分页处理
        PageInfo pageInfo = new PageInfo<>(reportUsers);
        return pageInfo.getList();
    }

    @Override
    public Boolean deleteReportCommentById(Integer id) {
        return reportCommentMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean insertReportComment(ReportComment reportComment) {
        reportComment.setCreateTime(LocalDateTime.now());
        reportComment.setUpdateTime(LocalDateTime.now());
        return reportCommentMapper.insertSelective(reportComment)>0;
    }

    @Override
    public ReportComment updateReportComment(ReportComment reportComment) {
        reportComment.setUpdateTime(LocalDateTime.now());
        reportCommentMapper.updateByPrimaryKeySelective(reportComment);
        return reportComment;
    }

    @Override
    public List<ReportComment> selectReportCommentById(Integer id) {
        List<ReportComment> reportCommentList = reportCommentMapper.selectReportCommentById(id);
        return reportCommentList;
    }

    @Override
    public List<ReportComment> selectListById(ReportComment reportComment) {
        return reportCommentMapper.selectListById(reportComment);
    }
}
