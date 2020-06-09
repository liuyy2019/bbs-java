package com.yang.bbs.mapper;

import com.yang.bbs.bean.Answer;
import org.apache.ibatis.jdbc.SQL;

public class AnswerSqlProvider {

    public String insertSelective(Answer record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("answer");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            sql.VALUES("createdate", "#{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.VALUES("updatetime", "#{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getReply() != null) {
            sql.VALUES("reply", "#{reply,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(Answer record) {
        SQL sql = new SQL();
        sql.SELECT("id, name, content, createdate, updatetime, status, reply");
        sql.FROM("answer");

        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getName() != null) {
            sql.WHERE("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getContent() != null) {
            sql.WHERE("content = #{content,jdbcType=VARCHAR}");
        }

        if (record.getCreatedate() != null) {
            sql.WHERE("createdate = #{createdate,jdbcType=TIMESTAMP}");
        }

        if (record.getUpdatetime() != null) {
            sql.WHERE("updatetime = #{updatetime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=INTEGER}");
        }

        if (record.getReply() != null) {
            sql.WHERE("reply = #{reply,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Answer record) {
        SQL sql = new SQL();
        sql.UPDATE("answer");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatedate() != null) {
            sql.SET("createdate = #{createdate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdatetime() != null) {
            sql.SET("updatetime = #{updatetime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getReply() != null) {
            sql.SET("reply = #{reply,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}