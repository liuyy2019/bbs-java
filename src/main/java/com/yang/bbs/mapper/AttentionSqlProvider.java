package com.yang.bbs.mapper;

import com.yang.bbs.bean.Attention;
import org.apache.ibatis.jdbc.SQL;

public class AttentionSqlProvider {

    public String insertSelective(Attention record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("attention");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        if (record.getNoticerId() != null) {
            sql.VALUES("noticer_id", "#{noticerId,jdbcType=INTEGER}");
        }
        
        if (record.getUsername() != null) {
            sql.VALUES("username", "#{username,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersex() != null) {
            sql.VALUES("usersex", "#{usersex,jdbcType=VARCHAR}");
        }
        
        if (record.getUserphone() != null) {
            sql.VALUES("userphone", "#{userphone,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticer() != null) {
            sql.VALUES("noticer", "#{noticer,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createtime", "#{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=CHAR}");
        }
        
        return sql.toString();
    }

    public String selectiveProvider(Attention record) {
        SQL sql = new SQL();
        sql.SELECT("id, user_id,noticer_id,username, usersex, userphone, noticer, sex, phone, createtime, status");
        sql.FROM("attention");
        if (record.getId() != null) {
            sql.WHERE("id = #{id,jdbcType=INTEGER}");
        }

        if (record.getUserId() != null) {
            sql.WHERE("user_id = #{userId,jdbcType=INTEGER}");
        }
        if (record.getNoticerId() != null) {
            sql.WHERE("noticer_id = #{noticerId,jdbcType=INTEGER}");
        }

        if (record.getUsername() != null) {
            sql.WHERE("username = #{username,jdbcType=VARCHAR}");
        }

        if (record.getUsersex() != null) {
            sql.WHERE("usersex = #{usersex,jdbcType=VARCHAR}");
        }

        if (record.getUserphone() != null) {
            sql.WHERE("userphone = #{userphone,jdbcType=VARCHAR} ");

        }

        if (record.getNoticer() != null) {
            sql.WHERE("noticer = #{noticer,jdbcType=VARCHAR}");
        }

        if (record.getSex() != null) {
            sql.WHERE("sex = #{sex,jdbcType=VARCHAR}");
        }

        if (record.getPhone() != null) {
            sql.WHERE("phone = #{phone,jdbcType=VARCHAR}");
        }

        if (record.getCreatetime() != null) {
            sql.WHERE("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.getStatus() != null) {
            sql.WHERE("status = #{status,jdbcType=CHAR}");
        }

        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Attention record) {
        SQL sql = new SQL();
        sql.UPDATE("attention");
        
        if (record.getUsername() != null) {
            sql.SET("username = #{username,jdbcType=VARCHAR}");
        }
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        if (record.getNoticerId() != null) {
            sql.SET("noticer_id = #{noticerId,jdbcType=INTEGER}");
        }
        
        if (record.getUsersex() != null) {
            sql.SET("usersex = #{usersex,jdbcType=VARCHAR}");
        }
        
        if (record.getUserphone() != null) {
            sql.SET("userphone = #{userphone,jdbcType=VARCHAR}");
        }
        
        if (record.getNoticer() != null) {
            sql.SET("noticer = #{noticer,jdbcType=VARCHAR}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createtime = #{createtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=CHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}