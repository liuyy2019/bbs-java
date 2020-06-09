package com.yang.bbs.mapper;

import com.yang.bbs.bean.ReportComment;
import org.apache.ibatis.jdbc.SQL;

public class ReportCommentSqlProvider {

    public String insertSelective(ReportComment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("report_comment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCommentId() != null) {
            sql.VALUES("comment_id", "#{commentId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentName() != null) {
            sql.VALUES("comment_name", "#{commentName,jdbcType=VARCHAR}");
        }
        
        if (record.getReportId() != null) {
            sql.VALUES("report_id", "#{reportId,jdbcType=INTEGER}");
        }
        
        if (record.getReportName() != null) {
            sql.VALUES("report_name", "#{reportName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReportReason() != null) {
            sql.VALUES("report_reason", "#{reportReason,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }


    public String selectiveProvider(ReportComment record) {
        SQL sql = new SQL();
        sql.SELECT("id, comment_id, comment_name, report_id, report_name, status, create_time, update_time,report_reason");
        sql.FROM("report_comment");

        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getCommentId() != null) {
            sql.WHERE("comment_id = #{commentId,jdbcType=INTEGER}");
        }

        if (record.getCommentName() != null) {
            sql.WHERE("comment_name = #{commentName,jdbcType=VARCHAR}");
        }

        if (record.getReportId() != null) {
            sql.WHERE("report_id = #{reportId,jdbcType=INTEGER}");
        }

        if (record.getReportName() != null) {
            sql.WHERE("report_name = #{reportName,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.WHERE("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdateTime() != null) {
            sql.WHERE("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getReportReason() != null) {
            sql.WHERE("report_reason = #{reportReason,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReportComment record) {
        SQL sql = new SQL();
        sql.UPDATE("report_comment");
        
        if (record.getCommentId() != null) {
            sql.SET("comment_id = #{commentId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentName() != null) {
            sql.SET("comment_name = #{commentName,jdbcType=VARCHAR}");
        }
        
        if (record.getReportId() != null) {
            sql.SET("report_id = #{reportId,jdbcType=INTEGER}");
        }
        
        if (record.getReportName() != null) {
            sql.SET("report_name = #{reportName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReportReason() != null) {
            sql.SET("report_reason = #{reportReason,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}