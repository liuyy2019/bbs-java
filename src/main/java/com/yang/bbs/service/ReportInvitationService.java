package com.yang.bbs.service;

import com.yang.bbs.bean.ReportInvitation;
import com.yang.bbs.bean.ReportUser;

import java.util.List;

/**
 * @Description
 * @Author liuyangyang
 * @Date 2020/4/29 16:44
 */
public interface ReportInvitationService {
    List<ReportInvitation> selectAll();

    List<ReportInvitation> selectList(ReportInvitation reportInvitation,Integer page,Integer size);

    Boolean deleteReportInvitationById(Integer id);

    Boolean insertReportInvitation(ReportInvitation reportInvitation);

    ReportInvitation updateReportInvitation(ReportInvitation reportInvitation);

    List<ReportInvitation> selectListById(ReportInvitation reportInvitation);
}
