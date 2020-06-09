package com.yang.bbs.service;

import com.yang.bbs.bean.ReportUser;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:31
 */
public interface ReportUserService {

    List<ReportUser> selectAll();

    List<ReportUser> selectList(ReportUser reportUser,Integer page,Integer size);

    Boolean deleteReportUserById(Integer id);

    Boolean insertReportUser(ReportUser reportUser);

    ReportUser updateReportUser(ReportUser reportUser);

    List<ReportUser> selectListById(ReportUser reportUser);
}
