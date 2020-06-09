package com.yang.bbs.mapper;

import com.yang.bbs.bean.Invitation;

import org.apache.ibatis.jdbc.SQL;

public class InvitationSqlProvider {


    public String insertSelective(Invitation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("invitation");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.VALUES("date", "#{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitors() != null) {
            sql.VALUES("visitors", "#{visitors,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=LONGVARCHAR}");
        }
        if (record.getClicks() != null) {
            sql.VALUES("clicks", "#{clicks,jdbcType=INTEGER}");
        }
        if (record.getReports() != null) {
            sql.VALUES("reports", "#{reports,jdbcType=INTEGER}");
        }

        if (record.getIssuerId() != null) {
            sql.VALUES("issuer_id", "#{issuerId,jdbcType=VARCHAR}");
        }
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(Invitation record) {
        SQL sql = new SQL();
        sql.SELECT("id, name, date, title, type, visitors, content,clicks,reports,issuer_id,status");
        sql.FROM("invitation");

        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null && !"".equals(record.getName())) {
            sql.WHERE("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getDate() != null) {
            sql.WHERE("date = #{date,jdbcType=TIMESTAMP}");
        }

        if (record.getTitle() != null && !"".equals(record.getTitle())) {
            sql.WHERE("title LIKE #{title,jdbcType=VARCHAR}");
        }

        if (record.getType() != null && !"".equals(record.getType())) {
            sql.WHERE("type = #{type,jdbcType=VARCHAR}");
        }

        if (record.getVisitors() != null) {
            sql.WHERE("visitors = #{visitors,jdbcType=INTEGER}");
        }

        if (record.getContent() != null) {
            sql.WHERE("content = #{content,jdbcType=LONGVARCHAR}");
        }
        if (record.getClicks() != null) {
            sql.WHERE("clicks = #{clicks,jdbcType=INTEGER}");
        }
        if (record.getReports() != null) {
            sql.WHERE("reports >= #{reports,jdbcType=INTEGER}");
        }

        if (record.getIssuerId() != null) {
            sql.WHERE("issuer_id = #{issuerId,jdbcType=VARCHAR}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=VARCHAR}");
        }

        return sql.toString();
    }


    public String updateByPrimaryKeySelective(Invitation record) {
        SQL sql = new SQL();
        sql.UPDATE("invitation");

        if (record.getReports() != null) {
            sql.SET("reports = #{reports,jdbcType=VARCHAR}");
        }
        if (record.getClicks() != null) {
            sql.SET("clicks = #{clicks,jdbcType=VARCHAR}");
        }
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getVisitors() != null) {
            sql.SET("visitors = #{visitors,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=LONGVARCHAR}");
        }
        if (record.getIssuerId() != null) {
            sql.SET("issuer_id = #{issuerId,jdbcType=VARCHAR}");
        }
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }


}