package com.yang.bbs.mapper;

import com.yang.bbs.bean.Announcement;
import org.apache.ibatis.jdbc.SQL;

public class AnnouncementSqlProvider {

    public String insertSelective(Announcement record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("announcement");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        if (record.getIssuer() != null) {
            sql.VALUES("issuer", "#{issuer,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(Announcement record) {
        SQL sql = new SQL();
        sql.SELECT("id, content, create_time, status, issuer, title");
        sql.FROM("announcement");
        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getContent() != null) {
            sql.WHERE("content = #{content,jdbcType=VARCHAR}");
        }

        if (record.getCreateTime() != null) {
            sql.WHERE("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }

        if (record.getIssuer() != null) {
            sql.WHERE("issuer = #{issuer,jdbcType=VARCHAR}");
        }

        if (record.getTitle() != null) {
            sql.WHERE("title = #{title,jdbcType=VARCHAR}");
        }
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Announcement record) {
        SQL sql = new SQL();
        sql.UPDATE("announcement");
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        if (record.getIssuer() != null) {
            sql.SET("issuer = #{issuer,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}