package com.yang.bbs.mapper;

import com.yang.bbs.bean.ReportInvitation;
import org.apache.ibatis.jdbc.SQL;

public class ReportInvitationSqlProvider {

    public String insertSelective(ReportInvitation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("report_invitation");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getInvitationId() != null) {
            sql.VALUES("invitation_id", "#{invitationId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIssuer() != null) {
            sql.VALUES("issuer", "#{issuer,jdbcType=VARCHAR}");
        }
        
        if (record.getReportId() != null) {
            sql.VALUES("report_id", "#{reportId,jdbcType=INTEGER}");
        }

        if (record.getReportId() != null) {
            sql.VALUES("issuer_id", "#{issuerId,jdbcType=INTEGER}");
        }
        
        if (record.getReportName() != null) {
            sql.VALUES("report_name", "#{reportName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }

        if (record.getReportReason() != null) {
            sql.VALUES("report_reason", "#{reportReason,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(ReportInvitation record) {
        SQL sql = new SQL();
        sql.SELECT("id, invitation_id, title, issuer, issuer_id, report_reason,report_id, report_name, create_time, update_time, status");
        sql.FROM("report_invitation");

        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getInvitationId() != null) {
            sql.WHERE("invitation_id = #{invitationId,jdbcType=INTEGER}");
        }

        if (record.getTitle() != null) {
            sql.WHERE("title = #{title,jdbcType=VARCHAR}");
        }

        if (record.getIssuer() != null) {
            sql.WHERE("issuer = #{issuer,jdbcType=VARCHAR}");
        }

        if (record.getIssuerId() != null) {
            sql.WHERE("issuer_id = #{issuerId,jdbcType=INTEGER}");
        }
        if (record.getReportId() != null) {
            sql.WHERE("report_id = #{reportId,jdbcType=INTEGER}");
        }

        if (record.getReportName() != null) {
            sql.WHERE("report_name = #{reportName,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.WHERE("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.WHERE("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }

        if (record.getReportReason() != null) {
            sql.WHERE("report_reason = #{reportReason,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReportInvitation record) {
        SQL sql = new SQL();
        sql.UPDATE("report_invitation");
        
        if (record.getInvitationId() != null) {
            sql.SET("invitation_id = #{invitationId,jdbcType=INTEGER}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIssuer() != null) {
            sql.SET("issuer = #{issuer,jdbcType=VARCHAR}");
        }
        
        if (record.getReportId() != null) {
            sql.SET("issuer_id = #{issuerId,jdbcType=INTEGER}");
        }

        if (record.getReportId() != null) {
            sql.SET("report_id = #{reportId,jdbcType=INTEGER}");
        }
        
        if (record.getReportName() != null) {
            sql.SET("report_name = #{reportName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getReportReason() != null) {
            sql.SET("report_reason = #{reportReason,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}