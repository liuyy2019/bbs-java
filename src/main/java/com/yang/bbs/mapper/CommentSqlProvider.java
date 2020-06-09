package com.yang.bbs.mapper;

import com.yang.bbs.bean.Comment;
import org.apache.ibatis.jdbc.SQL;

public class CommentSqlProvider {

    public String insertSelective(Comment record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("comment");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInvitationId() != null) {
            sql.VALUES("invitation_id", "#{invitationId,jdbcType=INTEGER}");
        }
        
        if (record.getInvitationTitle() != null) {
            sql.VALUES("invitation_title", "#{invitationTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getInvitationName() != null) {
            sql.VALUES("invitation_name", "#{invitationName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getAmount() != null) {
            sql.VALUES("amount", "#{amount,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        if (record.getReports() != null) {
            sql.VALUES("reports", "#{reports,jdbcType=INTEGER}");
        }
        if (record.getIssuerId() != null) {
            sql.VALUES("issuer_id", "#{issuerId,jdbcType=INTEGER}");
        }
        return sql.toString();
    }

    public String selectiveProvider(Comment record) {
        SQL sql = new SQL();
        sql.SELECT("id, content, name, createtime, invitation_id, invitation_title, invitation_name, status, amount, user_id, reports,issuer_id");
        sql.FROM("comment");

        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getContent() != null) {
            sql.WHERE("content = #{content,jdbcType=VARCHAR}");
        }

        if (record.getName() != null) {
            sql.WHERE("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getCreatetime() != null) {
            sql.WHERE("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.getInvitationId() != null) {
            sql.WHERE("invitation_id = #{invitationId,jdbcType=INTEGER}");
        }

        if (record.getInvitationTitle() != null) {
            sql.WHERE("invitation_title = #{invitationTitle,jdbcType=VARCHAR}");
        }

        if (record.getInvitationName() != null) {
            sql.WHERE("invitation_name = #{invitationName,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }

        if (record.getAmount() != null) {
            sql.WHERE("amount = #{amount,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        }
        if (record.getReports() != null) {
            sql.WHERE("reports = #{reports,jdbcType=INTEGER}");
        }
        if (record.getIssuerId() != null) {
            sql.WHERE("issuer_id = #{issuerId,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Comment record) {
        SQL sql = new SQL();
        sql.UPDATE("comment");
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getInvitationId() != null) {
            sql.SET("invitation_id = #{invitationId,jdbcType=INTEGER}");
        }
        
        if (record.getInvitationTitle() != null) {
            sql.SET("invitation_title = #{invitationTitle,jdbcType=VARCHAR}");
        }
        
        if (record.getInvitationName() != null) {
            sql.SET("invitation_name = #{invitationName,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getAmount() != null) {
            sql.SET("amount = #{amount,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        if (record.getReports() != null) {
            sql.SET("reports = #{reports,jdbcType=INTEGER}");
        }
        if (record.getIssuerId() != null) {
            sql.SET("issuer_id = #{issuerId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}