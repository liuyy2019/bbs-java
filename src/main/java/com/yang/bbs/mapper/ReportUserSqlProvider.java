package com.yang.bbs.mapper;

import com.yang.bbs.bean.ReportUser;
import org.apache.ibatis.jdbc.SQL;

public class ReportUserSqlProvider {

    public String insertSelective(ReportUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("report_user");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
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
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }

        if (record.getReportReason() != null) {
            sql.VALUES("report_reason", "#{reportReason,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(ReportUser record) {
        SQL sql = new SQL();
        sql.SELECT("id, user_id, user_name, create_time, report_id,report_reason, report_name, status, update_time");
        sql.FROM("report_user");
        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        }

        if (record.getUserName() != null) {
            sql.WHERE("user_name = #{userName,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.WHERE("create_time = #{createTime,jdbcType=TIMESTAMP}");
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

        if (record.getUpdateTime() != null) {
            sql.WHERE("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReportUser record) {
        SQL sql = new SQL();
        sql.UPDATE("report_user");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getReportId() != null) {
            sql.SET("report_id = #{reportId,jdbcType=INTEGER}");
        }
        
        if (record.getReportName() != null) {
            sql.SET("report_name = #{reportName,jdbcType=VARCHAR}");
        }

        if (record.getReportReason() != null) {
            sql.SET("report_reason = #{reportReason,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}