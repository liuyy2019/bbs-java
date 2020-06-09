package com.yang.bbs.mapper;

import com.yang.bbs.bean.Collection;
import org.apache.ibatis.jdbc.SQL;

public class CollectionSqlProvider {

    public String insertSelective(Collection record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("collection");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        if (record.getInvitationId() != null) {
            sql.VALUES("invitation_id", "#{invitationId,jdbcType=INTEGER}");
        }
        if (record.getIssuerId() != null) {
            sql.VALUES("issuer_id", "#{issuerId,jdbcType=INTEGER}");
        }
        
        if (record.getCollector() != null) {
            sql.VALUES("collector", "#{collector,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIssuer() != null) {
            sql.VALUES("issuer", "#{issuer,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(Collection record) {
        SQL sql = new SQL();
        sql.SELECT("id, collector, title, issuer, createtime, type, status,user_id,invitation_id,issuer_id");
        sql.FROM("collection");
        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getCollector() != null) {
            sql.WHERE("collector = #{collector,jdbcType=VARCHAR}");
        }

        if (record.getTitle() != null) {
            sql.WHERE("title = #{title,jdbcType=VARCHAR}");
        }

        if (record.getIssuer() != null) {
            sql.WHERE("issuer = #{issuer,jdbcType=VARCHAR}");
        }

        if (record.getCreatetime() != null) {
            sql.WHERE("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.getType() != null) {
            sql.WHERE("type = #{type,jdbcType=VARCHAR}");
        }


        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }
        if (record.getUserId() != null) {
            sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        }
        if (record.getInvitationId() != null) {
            sql.WHERE("invitation_id = #{invitationId,jdbcType=INTEGER}");
        }
        if (record.getIssuerId() != null) {
            sql.WHERE("issuer_id = #{issuerId,jdbcType=INTEGER}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Collection record) {
        SQL sql = new SQL();
        sql.UPDATE("collection");
        
        if (record.getCollector() != null) {
            sql.SET("collector = #{collector,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIssuer() != null) {
            sql.SET("issuer = #{issuer,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }

        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        if (record.getStatus() != null) {
            sql.SET("invitation_id = #{invitationId,jdbcType=INTEGER}");
        }
        if (record.getIssuerId() != null) {
            sql.SET("issuer_id = #{issuerId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}